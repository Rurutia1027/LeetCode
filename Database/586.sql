-- Orders#order_number pk
-- customer_number who the largest number of orders.
-- group by customer_number count(order_number)
-- order by count(order_number) limit 1 -- to keep the max

select o.customer_number
from Orders o
group by
    o.customer_number
order by count(o.order_number) desc
limit 1;