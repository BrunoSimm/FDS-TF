INSERT INTO usuarios (nome, email, categoria_de_usuario) VALUES ('Bruno S','bruno.s@gmail.com','ADMINISTRADOR');
INSERT INTO usuarios (nome, email, categoria_de_usuario) VALUES ('Joao B','joao.b@gmail.com','USUARIO_OFICIAL');
INSERT INTO usuarios (nome, email, categoria_de_usuario) VALUES ('Rafael C','rafael.c@gmail.com','CIDADAO');
INSERT INTO usuarios (nome, email, categoria_de_usuario) VALUES ('Daniel S','daniel.s@gmail.com','CIDADAO');
INSERT INTO usuarios (nome, email, categoria_de_usuario) VALUES ('Maurício A','mauricio.a@gmail.com','CIDADAO');
INSERT INTO usuarios (nome, email, categoria_de_usuario) VALUES ('Juliana G','juliana.g@gmail.com','CIDADAO');

INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Centro','Rua Julio de Castilhos',458,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Centro','Rua Julio de Castilhos',144,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Barra do Jacaré','Rua Getúlio Vargas',11,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Porto XV','Estrada Porto XV',1122,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Porto XV','Rua Tiradentes',121,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Vila Moca','Rua Osvaldo Aranha',23,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Vila Moca','Rua Iaraí',85,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Vila Moca','Rua Agenor Pereti',587,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Planalto','Rua Alegrete',466,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Planalto','Rua Uruguaia',66,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Planalto','Rua Bagé',785,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Planalto','Rua Livramento',907,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Planalto','Rua Sarandi',0,'Encantado','RS');
INSERT INTO enderecos (bairro, logradouro, numero, cidade, estado) VALUES ('Lambari','Rua São José',78,'Encantado','RS');

INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (3,'Poste caído','Maldito poste caiu após acidente da motoca e ninguém vem consertar.','2020-3-1',1,'zh.com.br/postecaido.jpg','Iluminação Pública','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (3,'Rua alagada','Alagamento do valão não seca nunca... Vou vender minha casa!','2021-5-4',2,'zh.com.br/valao.jpg','Saneamento','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (3,'Arvore gigante em risco de queda','','2019-12-15',3,'zh.com.br/arvorevelha.jpg','Manutenção Urbana','RESOLVIDA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (5,'Aglomeração clandestina','','2021-5-24',4,'zh.com.br/','Risco COVID-19','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (5,'Bingo da Igreja','','2018-1-27',5,'zh.com.br/','Cuidado com Idosos','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (6,'Arraial da cidade','Joãozinho quer que promovam o arraial da cidade no mês que vem. O moloque só incomoda em casa, sem vergonha!','2021-6-24',6,'zh.com.br/','Eventos Sociais','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (4,'Pracinha da esquina','','2021-2-2',7,'zh.com.br/','Praças Públicas','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (4,'Grama alta','Molecada anda sumindo no esconde-esconde nesse matagal.','2020-12-24',8,'zh.com.br/','Praças Públicas','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (4,'Buraco na via','Essa cratera tá de parabéns... já comemora 5 anos e mais de 50 pneus furados!!!','2016-6-14',9,'zh.com.br/','Vias Públicas','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (6,'Calçada quebrada','Calçada tá um horror.. tão esperando alguém cair e pefir indenização?','2020-10-11',10,'zh.com.br/','Manutenção Urbana','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (6,'Terreno baldio','Relatos de plantas com cheiro característicos vindo do terreno e movimentações noturnas suspeitas.','2021-01-12',11,NULL,'Guarda municipal','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (6,'Lixo espalhado','Panfletagem das eleições avacalhou a rua. Tá tudo espalhado e sujo... tudo ficha suja!','2020-10-15',12,'zh.com.br/','Saneamento','ABERTA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (5,'Boeiro entupido','','2019-9-2',13,'zh.com.br/','Saneamento','ENCERRADA');
INSERT INTO reclamacoes (usuario_id, titulo, descricao, data, endereco_id, imagem, categoria, status) VALUES (3,'Boca de lobo perigosa','Crianças da vizinhança alegam terem visto um palhaço dentro da calçada. Testemunhas notaram estranhos balões nos arredores.','2019-1-17',14,'','Guarda municipal','RESOLVIDA');

UPDATE enderecos SET reclamacao_id = id;

INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (3,'Comentario1','2021-3-1','',1);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (3,'Comentario2','2021-3-2','',1);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (4,'Comentario3','2021-3-3','',1);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (2,'Comentario4','2021-3-4','/foto1.jpg',1);

INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (3,'Comentario5','2021-3-5','',2);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (5,'Comentario6','2021-3-6','',2);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (3,'Comentario7','2021-3-7','',2);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (2,'Comentario8','2021-3-8','/foto2.jpg',2);

INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (2,'Comentario9','2021-3-9','',3);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (5,'Comentario10','2021-3-10','',3);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (3,'Comentario11','2021-3-11','',3);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (3,'Comentario12','2021-3-12','/foto3.jpg',3);

INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (2,'Comentario13','2021-3-13','',4);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (4,'Comentario14','2021-3-14','',4);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (3,'Comentario15','2021-3-15','',4);
INSERT INTO comentarios (id_usuario_fk, descricao, data, imagem, id_reclamacao_fk) VALUES (5,'Comentario16','2021-3-16','/foto4.jpg',4);
