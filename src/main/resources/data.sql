INSERT INTO tb_role (id, name)
SELECT 1, 'ADMIN'
WHERE NOT EXISTS (
    SELECT 1 FROM tb_role WHERE id = 1
);
INSERT INTO tb_role (id, name)
SELECT 2, 'BASIC'
WHERE NOT EXISTS (
    SELECT 1 FROM tb_role WHERE id = 2
);