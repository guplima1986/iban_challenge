create table subscription
(
    id            bigint auto_increment
        primary key,
    consent       bit          not null,
    date_of_birth date         not null,
    email         varchar(255) not null,
    first_name    varchar(255) null,
    gender        int          null,
    campaign_id   bigint       null,
    foreign key (campaign_id) references campaign (id)
);