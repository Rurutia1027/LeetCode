-- UK; Employee#empId
-- FK; Bonus#empId
--  each employee with a bonus less than 1000.
-- any order.

-- left join Employee e -> Bonus b on empId equal
-- where b.bonus < 1000

select e.name, b.bonus
from Employee e
    left join Bonus b on e.empId = b.empId
where
    b.bonus is null
    or b.bonus < 1000;