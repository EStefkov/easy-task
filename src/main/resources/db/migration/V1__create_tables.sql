-- V1__create_tables.sql

-- Create the Projects table
CREATE TABLE projects (
                          project_id INT PRIMARY KEY AUTO_INCREMENT,
                          project_name VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create the Tasks table
CREATE TABLE tasks (
                       task_id INT PRIMARY KEY AUTO_INCREMENT,
                       task_name VARCHAR(255) NOT NULL,
                       project_id INT,
                       status VARCHAR(50) DEFAULT 'To-do',
                       start_date DATE,
                       end_date DATE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       priority INT,
                       CONSTRAINT fk_project
                           FOREIGN KEY (project_id) REFERENCES projects(project_id)
                               ON DELETE SET NULL
);

-- Create the Time Logs table
CREATE TABLE time_logs (
                           log_id INT PRIMARY KEY AUTO_INCREMENT,
                           task_id INT,
                           log_date DATE NOT NULL,
                           start_time TIME NOT NULL,
                           end_time TIME NOT NULL,
                           duration INT NOT NULL,  -- Duration in minutes (or seconds, depending on your preference)
                           CONSTRAINT fk_task
                               FOREIGN KEY (task_id) REFERENCES tasks(task_id)
                                   ON DELETE CASCADE
);
