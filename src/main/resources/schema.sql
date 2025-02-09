-- Database: Bug
CREATE Database Bug;
DROP Database Bug;

-- Create User Table

CREATE TABLE app_user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
    -- Add other user fields as necessary
);

-- Create Bug Table
CREATE TABLE bug (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    status VARCHAR(50),
    assigned_user_id BIGINT,
    priority_id BIGINT,  -- Add this line for priority
    FOREIGN KEY (assigned_user_id) REFERENCES app_user(id),
    FOREIGN KEY (priority_id) REFERENCES priority(id)  -- Add foreign key reference to priority
);

-- Create Priority Table (if applicable)
CREATE TABLE priority (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);
