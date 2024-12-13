-- Insert sample users
INSERT INTO users (id, username, password) VALUES (1, 'user1', 'password123');

-- Insert sample questions
INSERT INTO question (id, category, difficulty, text) VALUES (1, 'Science', 'easy', 'What is the chemical symbol for water?');
INSERT INTO question (id, category, difficulty, text) VALUES (2, 'Math', 'medium', 'What is 12 * 12?');
INSERT INTO question (id, category, difficulty, text) VALUES (3, 'History', 'hard', 'Who was the first President of the United States?');
INSERT INTO question (id, category, difficulty, text) VALUES (4, 'Geography', 'easy', 'What is the capital of England?');
INSERT INTO question (id, category, difficulty, text) VALUES (5, 'History', 'medium', 'Who painted the famous artwork Mona Lisa?');

-- Insert options for questions
INSERT INTO question_options (question_id, options) VALUES (1, '["H2O", "O2", "CO2", "HO"]');
INSERT INTO question_options (question_id, options) VALUES (2, '["124", "121", "112", "144"]');
INSERT INTO question_options (question_id, options) VALUES (3, '["Abraham Lincoln", "George Washington", "Thomas Jefferson", "John Adams"]');
INSERT INTO question_options (question_id, options) VALUES (4, '["Brussels", "London", "Manchester", "York"]');
INSERT INTO question_options (question_id, options) VALUES (5, '["Leonardo Da Vinci", "Vincent Van Gogh", "Johannes Vermeer", "Michelangelo"]');

-- Insert correct answers
INSERT INTO question_correct_answers (question_id, correct_answers) VALUES (1, '[0]');
INSERT INTO question_correct_answers (question_id, correct_answers) VALUES (2, '[3]');
INSERT INTO question_correct_answers (question_id, correct_answers) VALUES (3, '[1]');
INSERT INTO question_correct_answers (question_id, correct_answers) VALUES (4, '[1]');
INSERT INTO question_correct_answers (question_id, correct_answers) VALUES (5, '[0]');