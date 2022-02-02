CREATE TRIGGER `alunos_AFTER_DELETE` AFTER DELETE ON `alunos` FOR EACH ROW BEGIN
	DELETE FROM presencas WHERE presencas.id = old.id;
END