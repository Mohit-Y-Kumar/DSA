# Write your MySQL query statement below
SELECT s.customer_id,COUNT(*) AS count_no_trans
FROM Visits s
LEFT JOIN Transactions t
ON s.visit_id =t.visit_id
WHERE t.transaction_id IS NULL
GROUP BY s.customer_id;
