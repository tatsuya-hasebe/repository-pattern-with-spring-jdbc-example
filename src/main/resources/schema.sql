create table if not exists todo (
  `id` bigint not null auto_increment,
  `title` varchar(255) not null,
  `desc` varchar(255) not null,
  `completed` boolean not null
);