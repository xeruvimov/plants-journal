CREATE TABLE plant
(
    id            uuid DEFAULT uuid_generate_v4(),
    created_by    varchar(255),
    date_created  TIMESTAMPTZ,
    modified_by   varchar(255),
    date_modified TIMESTAMPTZ,
    name          varchar,
    description   varchar,
    PRIMARY KEY (id)
);

CREATE TABLE event
(
    id            uuid DEFAULT uuid_generate_v4(),
    created_by    varchar(255),
    date_created  TIMESTAMPTZ,
    modified_by   varchar(255),
    date_modified TIMESTAMPTZ,
    event_type    varchar,
    date          bigint,
    message       varchar,
    plant_id      uuid,
    constraint plant foreign key (plant_id) references plant (id)
);