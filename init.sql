DELETE FROM enrollments;
INSERT INTO enrollments (
        enrollment_id,
        group_id,
        semester,
        subject_id,
        user_id
    )
VALUES (
        '5682bf45-e1c2-4421-9266-491964eb2222',
        'cca4c365-befb-4d4b-bd42-d9b92384a57d',
        '2022-I',
        '1',
        'fd6644f8-f987-4da4-93c3-8b25e3a37f63'
    ),
    (
        '2a474f4e-5f82-41f5-baea-fbc98b41d06e',
        '2d3c0e52-a09c-47db-8c42-8028f6e9856c',
        '2022-I',
        '4',
        'fd6644f8-f987-4da4-93c3-8b25e3a37f63'
    ),
    (
        'cc9c6a8d-3193-4cc9-a4ba-42bfa5ee2f10',
        'd0b5c4b5-5b1f-4b2b-9b2c-9b2c9b2c9b2d',
        '2022-I',
        '2',
        'fd6644f8-f987-4da4-93c3-8b25e3a37f63'
    );