-- 23. The name and date established of parks opened in the 1960s (6 rows)

select park_name, date_established from park where date_established between '1960/01/01' and '1969/12/31'