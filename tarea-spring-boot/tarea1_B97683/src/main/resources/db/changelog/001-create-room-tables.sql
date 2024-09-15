CREATE TABLE B97683_ROOM (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    createdBy VARCHAR(100) NOT NULL
);

CREATE TABLE B97683_USER (
    id UUID PRIMARY KEY,
    alias VARCHAR(100) NOT NULL,
    roomID UUID NOT NULL,
    CONSTRAINT FK_RoomID FOREIGN KEY (roomID) REFERENCES B97683_ROOM(id)
);

CREATE TABLE B97683_ROOM_MESSAGE (
    id UUID PRIMARY KEY,
    createdOn TIMESTAMP WITH TIME ZONE NOT NULL,
    message VARCHAR(100) NOT NULL,
    roomID UUID NOT NULL,
    createdBy VARCHAR(100) NOT NULL,

    CONSTRAINT FK_RoomID_Message FOREIGN KEY (roomID) REFERENCES B97683_ROOM(id)
 );