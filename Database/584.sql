-- Customer PK: id

-- not referred by the customer with id = 2. c.referee_id != 2
--  any order.

select c.name
from Customer c
where
    c.referee_id != 2
    or c.referee_id is null;