create table if not exists todo (
  `id` bigint not null,
  `title` varchar(255) not null,
  `desc` varchar(255) not null,
  `done` boolean not null
);