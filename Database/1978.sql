-- PK: employee_id
-- cond: salary < 30000 and manager_id
-- order: ordered by employee_id.

select e.employee_id
from Employees e
where
    e.manager_id not in(
        select employee_id
        from Employees
    )
    and e.salary < 30000
order by e.employee_id;