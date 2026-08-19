# Write your MySQL query statement below
select s.student_id,
s.student_name,
sub.subject_name,
COALESCE(subq.no_of_attempt,0) as attended_exams
from Students s
cross join Subjects sub
left join
(
    select student_id,subject_name,COUNT(*) as no_of_attempt
    from Examinations
    group by student_id,subject_name
    order by student_id,subject_name

)subq
on s.student_id=subq.student_id
and sub.subject_name = subq.subject_name
order by s.student_id ,sub.subject_name;