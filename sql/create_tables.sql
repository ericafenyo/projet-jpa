create table casts
(
    id             bigint auto_increment
        primary key,
    birth_date     date         null,
    height         varchar(255) null,
    imdb_id        varchar(255) null,
    name           varchar(255) null,
    raw_birth_date json         null,
    url            varchar(255) null,
    location_id    bigint       null
)
    engine = MyISAM;

create index FKbxy2wxmb6vopuy4u9twt7yl7a
    on casts (location_id);

create table countries
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null,
    url  varchar(255) null
)
    engine = MyISAM;

create table directors
(
    id             bigint auto_increment
        primary key,
    birth_date     date         null,
    height         varchar(255) null,
    imdb_id        varchar(255) null,
    name           varchar(255) null,
    raw_birth_date json         null,
    url            varchar(255) null,
    birth_place_id bigint       null
)
    engine = MyISAM;

create index FKjfmxrec063763q5jpnuqa1nj3
    on directors (birth_place_id);

create table genres
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

create table languages
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

create table locations
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

create table movie_cast
(
    movie_id bigint not null,
    cast_id  bigint not null
)
    engine = MyISAM;

create index FKh3ht4nyhscwpt25ikwdu7lfqj
    on movie_cast (movie_id);

create index FKo78v5in1r4c6t3fcu7cganri5
    on movie_cast (cast_id);

create table movie_director
(
    movie_id    bigint not null,
    director_id bigint not null
)
    engine = MyISAM;

create index FK9ydac07lpj14ahlf1wcep7qyq
    on movie_director (movie_id);

create index FKextapvuxebgo6t0p1m8ivfb61
    on movie_director (director_id);

create table movie_genre
(
    movie_id bigint not null,
    genre_id bigint not null
)
    engine = MyISAM;

create index FK3pdaf1ai9eafeypc7qe401l07
    on movie_genre (genre_id);

create index FKg7f38h6umffo51no9ywq91438
    on movie_genre (movie_id);

create table movies
(
    id                   bigint auto_increment
        primary key,
    imdb_id              varchar(20) null,
    name                 varchar(65) null,
    plot                 text        null,
    rating               double      null,
    url                  text        null,
    year                 int         null,
    country_id           bigint      null,
    language_id          bigint      null,
    shooting_location_id bigint      null,
    constraint UK_gqxr8m8iu1p4r6w3s0d875gc2
        unique (imdb_id),
    constraint UK_need1sfwodvn2yjle40es9twm
        unique (name)
)
    engine = MyISAM;

create index FK6twg1wl11hks1j8xespmv0se7
    on movies (language_id);

create index FKauqu1stthnujo0jf5dpws22y6
    on movies (shooting_location_id);

create index FKbih7y2b2lwdg87s5gosghnu99
    on movies (country_id);

create table roles
(
    id       bigint auto_increment
        primary key,
    name     varchar(255) null,
    cast_id  bigint       null,
    movie_id bigint       null
)
    engine = MyISAM;

create index FKbqn9pdphryoe4bp8q8ox957h3
    on roles (cast_id);

create index FKth07k2vg8bv6xi8mp86vw1ln0
    on roles (movie_id);

