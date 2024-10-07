-- Insert sample data into Projects table
INSERT INTO projects (project_name, created_at) VALUES
                                                    ('Time Management App', '2024-10-03 12:00:00'),
                                                    ('Personal Task Organizer', '2024-10-02 09:00:00'),
                                                    ('Client Project Tracker', '2024-10-01 15:30:00');

-- Insert sample data into Tasks table
INSERT INTO tasks (task_name, project_id, status, start_date, end_date, priority) VALUES
                                                                                      ('Design API Structure', 1, 'To-do', '2024-10-04', '2024-10-06', 1),
                                                                                      ('Develop Frontend UI', 1, 'In Progress', '2024-10-05', '2024-10-10', 2),
                                                                                      ('Create Database Schema', 2, 'Completed', '2024-09-30', '2024-10-02', 3);

-- Insert sample data into Time Logs table
INSERT INTO time_logs (task_id, log_date, start_time, end_time, duration) VALUES
                                                                              (1, '2024-10-04', '09:00:00', '11:00:00', 120),
                                                                              (2, '2024-10-05', '13:00:00', '15:00:00', 120),
                                                                              (3, '2024-09-30', '10:00:00', '12:30:00', 150);