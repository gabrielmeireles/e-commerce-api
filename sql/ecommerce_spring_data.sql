drop table if exists colors;
drop table if exists tags;
drop table if exists product;

create table `product` (
  `id` int not null,
  `category` varchar(255),
  `fabric` varchar(255),
  `name` varchar(255),
  `price` double,
  primary key (`id`)
);

create table `colors` (
  `product_id` int not null,
  `black` bit(1),
  `blue` bit(1),
  `white` bit(1),
  primary key (`product_id`),
  constraint fk_color_product foreign key (`product_id`) references `product`(`id`) on delete cascade
);

create table `tags` (
	`product_id` int not null,
    `tag` varchar(255) not null,
    
    primary key (`product_id`, `tag`),
    constraint fk_tag_product foreign key (`product_id`) references `product`(`id`) on delete cascade
);