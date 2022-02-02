CREATE TRIGGER `alunos_AFTER_INSERT` AFTER INSERT ON `alunos` FOR EACH ROW BEGIN
	INSERT INTO alunos.presencas(id, presente)
    VALUES (null, false);
END