create table if not exists plants_collection
(
    id            uuid DEFAULT uuid_generate_v4(),
    created_by    varchar(255),
    date_created  TIMESTAMPTZ,
    modified_by   varchar(255),
    date_modified TIMESTAMPTZ,
    title         varchar(255),
    user_id       uuid,
    primary key (id),
    constraint user_ref foreign key (user_id) references user_rg (id)
);

create table if not exists plants_collection_ref
(
    collection_id uuid references plants_collection (id) on update cascade on delete cascade,
    plant_id      uuid references plant (id) on update cascade on delete cascade,
    constraint collection_plant_invariance primary key (collection_id, plant_id)
);