-- distance traveled by each user

-- step-1: join users -> rides
-- step-2: group by users#id(unique-key), sum(rides#distance)

select u.name, coalesce(sum(r.distance), 0) as travelled_distance
from Users u
    left join Rides r on u.id = r.user_id
group by
    u.id,
    u.name
order by travelled_distance desc, u.name;