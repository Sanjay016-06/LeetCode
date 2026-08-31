select w2.id from Weather w1 cross join Weather w2 where w2.temperature > w1.temperature and 
date_sub(w2.recordDate,interval 1 Day ) = w1.recordDate