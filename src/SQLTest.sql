Postgresql

with
reason_counts as (
    select status,
        coalesce(failure_reason, 'Unknown') as failure_reason,
        count(*) as reason_count
    from transactions  where status = 'failure' group by status, coalesce(failure_reason, 'Unknown')
),
failure_reason_list as (
    select status,
        string_agg( failure_reason, ',' order by reason_count desc, failure_reason asc ) as failure_reasons
    from reason_counts group by status
),
transaction_summary as (
    select status, count(*) as total_transactions,
        round(sum(amount), 2) as total_amount
    from transactions group by status
)
select ts.status, ts.total_transactions,ts.total_amount,
    case
        when ts.status = 'success' then 'N/A'
        else coalesce(frl.failure_reasons, 'Unknown')
    end as failure_reasons
from transaction_summary ts
left join failure_reason_list frl
    on ts.status = frl.status
order by ts.status asc;
---------------------------------------------------------------
MYSQL
-----

WITH reason_stats AS (
    SELECT
        status,
        CASE
            WHEN status = 'success' THEN 'N/A'
            ELSE COALESCE(failure_reason, 'Unknown')
        END AS reason,
        COUNT(*)    AS cnt,
        SUM(amount) AS amt
    FROM transactions
    GROUP BY status, reason
)
SELECT
    status,
    CAST(SUM(cnt) AS SIGNED)     AS total_transactions,
    ROUND(SUM(amt), 2)           AS total_amount,
    GROUP_CONCAT(reason ORDER BY cnt DESC, reason ASC SEPARATOR ',') AS failure_reasons
FROM reason_stats
GROUP BY status
ORDER BY status ASC;




-------------

with reason_stats as (
    select
        status,
        case
            when status = 'success' then 'N/A'
            else coalesce(failure_reason, 'Unknown')
        end as reason,
        count(*)    as cnt,
        sum(amount) as amt
    from transactions
    group by status, reason
)
select
    status,
    cast(sum(cnt) as signed)     as total_transactions,
    round(sum(amt), 2)           as total_amount,
    group_concat(reason order by cnt desc, reason asc separator ',') as failure_reasons
from reason_stats
group by status
order by status asc;






