--changeset compass_answers
create table compass_answers(
  ${id},
  compassSlug text not null,
  lang text not null,
  ipAddress text,
  userAgent text,
  answers jsonb not null,
  updatedAt timestamptz default now() not null
);

--changeset compass_answers_history
create trigger compass_answers_history after update on compass_answers for each row execute procedure add_change_history();
