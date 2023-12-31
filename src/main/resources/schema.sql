CREATE TABLE Members (
    MB_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    MB_NAME VARCHAR(255) not null,
    MB_BIRTH DATE,
    MB_ADRESS VARCHAR(255),
    MB_PHONE VARCHAR(20) not null,
    MB_EMAIL VARCHAR(255),
    MB_ENTRYDATE DATE not null
);

CREATE TABLE Authors (
    AU_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    AU_NAME VARCHAR(255) not null
);

CREATE TABLE Publishers(
    PB_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    PB_NAME VARCHAR(255) not null
);

CREATE TABLE Books (
    BK_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    BK_TITLE VARCHAR(255) not null,
    BK_AUTHOR BIGINT not null,
    BK_PUBLISHER BIGINT not null,
    BK_YEAR VARCHAR(255),
    BK_GENRE VARCHAR(255) not null,
    BK_AMOUNT INT not null,
    FOREIGN KEY (BK_AUTHOR) REFERENCES Authors (AU_ID) ON DELETE CASCADE,
    FOREIGN KEY (BK_PUBLISHER) REFERENCES Publishers (PB_ID) ON DELETE CASCADE
);

CREATE TABLE Loans (
    LO_ID BIGINT PRIMARY KEY AUTO_INCREMENT,
    LO_BOOKID BIGINT not null,
    LO_MEMBERID BIGINT not null,
    LO_LOANDATE DATE not null,
    LO_LOANLIMITDATE DATE not null,
    LO_RETURNDATE DATE,
    LO_STATE VARCHAR(255) not null,
    FOREIGN KEY (LO_BOOKID) REFERENCES Books (BK_ID) ON DELETE CASCADE,
    FOREIGN KEY (LO_MEMBERID) REFERENCES Members (MB_ID) ON DELETE CASCADE
);


