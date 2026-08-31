# Write your MySQL query statement below
select u.user_id as buyer_id, u.join_date,
SUM(
    CASE
        WHEN year(o.order_date) = 2019 THEN 1 ELSE 0 END
) as orders_in_2019
from Users u
LEFT JOIN Orders o ON u.user_id = o.buyer_id
GROUP BY u.user_id