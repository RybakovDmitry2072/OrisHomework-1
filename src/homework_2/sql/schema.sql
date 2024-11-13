create table driver (
                        driver_id serial primary key,
                        first_name varchar(50) not null,
                        last_name varchar(50) not null,
                        age integer not null check ( age > 0 and age < 100 )
)