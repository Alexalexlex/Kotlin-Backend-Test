CREATE TABLE diets (
    id uuid NOT NULL,
    title character varying(100) NOT NULL,
    description text NOT NULL,
    image text NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone
);

CREATE TABLE users (
    id uuid NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    email character varying(100) NOT NULL UNIQUE,
    password character varying(72) NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone,
    deleted_at timestamp without time zone
);
