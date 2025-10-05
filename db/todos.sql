--changeset compass
create table todos(
  ${id},
  item text not null,
  completedAt timestamptz
);

--changeset compass:drop
drop table todos;
