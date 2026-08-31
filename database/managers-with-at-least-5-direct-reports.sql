select e.name 
from Employee e
join Employee  emp  
on e.id = emp.managerId 
group by e.name,e.id
having count(*) > 4 ;