--Not used, using ddl.sql instead of this configuration--
create table movies (
  id bigint primary key,
  title varchar(64) not null, -- movie must have a name
  year int,
  mpaa_rating varchar(8),
  runtime int,
  critics_consensus varchar(254),
  synopsis varchar(254)
);

create table release_dates (
  id bigint auto_increment primary key,
  movieId bigint not null, -- references movies.id
  theater varchar(32),

  CONSTRAINT fk_movie_release FOREIGN KEY (movieId) REFERENCES movies(id)
);

create table ratings (
  id bigint auto_increment primary key,
  movieId bigint not null, -- references movies.id
  critics_rating varchar(16),
  critics_score int,
  audience_rating varchar(16),
  audience_score int,

  CONSTRAINT fk_movie_ratings FOREIGN KEY (movieId) REFERENCES movies(id)
);

create table posters (
  id bigint auto_increment primary key,
  movieId bigint not null, -- references movies.id
  thumbnail varchar(256),
  profile varchar(256),
  detailed varchar(256),
  original varchar(256),

  CONSTRAINT fk_movie_posters FOREIGN KEY (movieId) REFERENCES movies(id)
);

create table alternate_ids (
  id bigint auto_increment primary key,
  movieId bigint not null, -- references movies.id
  site varchar(32) not null,
  site_id varchar(32) not null,

  CONSTRAINT fk_movie_alternate FOREIGN KEY (movieId) REFERENCES movies(id)
);

create table links (
  id bigint auto_increment primary key,
  movieId bigint not null, -- references movies.id
  self varchar(128),
  alternate varchar(128),
  cast varchar(128),
  review varchar(128),
  similar varchar(128),

  CONSTRAINT fk_movie_links FOREIGN KEY (movieId) REFERENCES movies(id)
);

create table abridged_cast (
  pid varchar(32) primary key,
  movieId bigint not null, -- references movies.id
  name varchar(128) not null,

  CONSTRAINT fk_movie_abridged FOREIGN KEY (movieId) REFERENCES movies(id)
);

create table abridged_cast_characters (
  id bigint auto_increment primary key,
  abridgedCastId varchar(32), -- references abridged_cast.id
  `character` varchar(128),

  CONSTRAINT fk_movie_abridged_char FOREIGN KEY (abridgedCastId) REFERENCES abridged_cast(pid)
);