-- Employees#employee_id UK
-- Salaries#employee_id UK
-- IDs of all the employees with missing information
-- employee_id in ascending order.

select coalesce(e.employee_id, s.employee_id) as employee_id
from Employees e full
    join Salaries s on e.employee_id = s.employee_id
where
    e.name is null
    or s.salary is null
order by employee_id