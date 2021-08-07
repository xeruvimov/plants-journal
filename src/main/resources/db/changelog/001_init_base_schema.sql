CREATE TABLE if not exists plant
(
    id            uuid DEFAULT uuid_generate_v4(),
    created_by    varchar(255),
    date_created  TIMESTAMPTZ,
    modified_by   varchar(255),
    date_modified TIMESTAMPTZ,
    name          varchar,
    description   varchar,
    user_id       uuid,
    PRIMARY KEY (id)
);

CREATE TABLE if not exists event
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
    PRIMARY KEY (id),
    constraint plant foreign key (plant_id) references plant (id)
);

CREATE TABLE if not exists user_rg
(
    id            uuid DEFAULT uuid_generate_v4(),
    created_by    varchar(255),
    date_created  TIMESTAMPTZ,
    modified_by   varchar(255),
    date_modified TIMESTAMPTZ,
    password      varchar(255),
    username      varchar(255),
    email         varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE if not exists role
(
    id            uuid DEFAULT uuid_generate_v4(),
    created_by    varchar(255),
    date_created  TIMESTAMPTZ,
    modified_by   varchar(255),
    date_modified TIMESTAMPTZ,
    name          varchar(255),
    PRIMARY KEY (id)
);

create table if not exists user_role
(
    user_id uuid references user_rg (id) ON UPDATE CASCADE ON DELETE CASCADE,
    role_id uuid references role (id) ON UPDATE CASCADE,
    CONSTRAINT bill_product_pkey PRIMARY KEY (user_id, role_id)
);