Part 1
-- job table columns and data types
-- id INT (auto-generated)
-- name VARCHAR(255)
-- employer_id INT (foreign key referencing employer table)
-- skills_id INT (foreign key referencing skill table)


-- Part 2
-- List the names of employers in St. Louis City
-- SELECT name FROM employer WHERE location = "St. Louis City";



--Part 3
--DROP TABLE job;

-

--Part 4

--SELECT * FROM skill INNER JOIN job_skills ON skill.id = job_skills.skills_id WHERE job_skills.jobs_id IS NOT NULL ORDER BY name ASC;