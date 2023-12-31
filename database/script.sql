USE SHOESONLINE
GO
CREATE TABLE Account (
    uID INT IDENTITY(1,1) NOT NULL,
    username NVARCHAR(10) NULL,
    pass NVARCHAR(10) NULL,
    isSell BIT NULL,
    isAdmin BIT NULL,
    email NVARCHAR(50) NULL,
    CONSTRAINT PK_Account PRIMARY KEY CLUSTERED (uID ASC)
) 

CREATE TABLE Cart (
    accountID INT NOT NULL,
    productID INT NOT NULL,
    amount INT NULL,
    maCart INT IDENTITY(1,1) NOT NULL,
    size NVARCHAR(50) NULL,
    CONSTRAINT PK_Cart PRIMARY KEY CLUSTERED (maCart ASC)
)

CREATE TABLE Category (
    cid INT NOT NULL,
    cname NVARCHAR(50) NULL,
    CONSTRAINT PK_Category PRIMARY KEY CLUSTERED (cid ASC)
)

CREATE TABLE Invoice (
    maHD INT IDENTITY(1,1) NOT NULL,
    accountID INT NULL,
    tongGia FLOAT NULL,
    ngayXuat DATETIME NULL,
    CONSTRAINT PK_Invoice PRIMARY KEY CLUSTERED (maHD ASC)
) 

CREATE TABLE Product (
    id INT IDENTITY(1,1) NOT NULL,
    name NVARCHAR(200) NULL,
    image NVARCHAR(500) NULL,
    price FLOAT NULL,
    title NVARCHAR(500) NULL,
    description NVARCHAR(MAX) NULL,
    cateID INT NOT NULL,
    sell_ID INT NOT NULL,
    model NVARCHAR(50) NULL,
    color NVARCHAR(50) NULL,
    delivery NVARCHAR(50) NULL,
    image2 NVARCHAR(500) NULL,
    image3 NVARCHAR(500) NULL,
    image4 NVARCHAR(500) NULL,
    CONSTRAINT PK_Product PRIMARY KEY CLUSTERED (id ASC)
)

CREATE TABLE Review (
    accountID INT NULL,
    productID INT NULL,
    contentReview NVARCHAR(500) NULL,
    dateReview DATE NULL,
    maReview INT IDENTITY(1,1) NOT NULL,
    CONSTRAINT PK_Review PRIMARY KEY CLUSTERED (maReview ASC)
)

CREATE TABLE SoLuongDaBan (
    productID INT NULL,
    soLuongDaBan INT NULL
) 

CREATE TABLE Supplier (
    idSupplier INT IDENTITY(1,1) NOT NULL,
    nameSupplier NVARCHAR(100) NULL,
    phoneSupplier NVARCHAR(50) NULL,
    emailSupplier NVARCHAR(200) NULL,
    addressSupplier NVARCHAR(200) NULL,
    cateID INT NULL,
    CONSTRAINT PK_Supplier PRIMARY KEY CLUSTERED (idSupplier ASC)
) 

CREATE TABLE TongChiTieuBanHang (
    userID INT NULL,
    TongChiTieu FLOAT NULL,
    TongBanHang FLOAT NULL
) 

GO
ALTER TABLE Cart WITH CHECK ADD CONSTRAINT FK_Cart_Account FOREIGN KEY(accountID) REFERENCES Account (uID);
ALTER TABLE Cart CHECK CONSTRAINT FK_Cart_Account;
ALTER TABLE Cart WITH CHECK ADD CONSTRAINT FK_Cart_Product FOREIGN KEY(productID) REFERENCES Product (id);
ALTER TABLE Cart CHECK CONSTRAINT FK_Cart_Product;

ALTER TABLE Invoice WITH CHECK ADD CONSTRAINT FK_Invoice_Account FOREIGN KEY(accountID) REFERENCES Account (uID);
ALTER TABLE Invoice CHECK CONSTRAINT FK_Invoice_Account;

ALTER TABLE Product WITH CHECK ADD CONSTRAINT FK_Product_Account FOREIGN KEY(sell_ID) REFERENCES Account (uID);
ALTER TABLE Product CHECK CONSTRAINT FK_Product_Account;

ALTER TABLE Product WITH CHECK ADD CONSTRAINT FK_Product_Category FOREIGN KEY(cateID) REFERENCES Category (cid);
ALTER TABLE Product CHECK CONSTRAINT FK_Product_Category;

ALTER TABLE Review WITH CHECK ADD CONSTRAINT FK_Review_Account FOREIGN KEY(accountID) REFERENCES Account (uID);
ALTER TABLE Review CHECK CONSTRAINT FK_Review_Account;

ALTER TABLE Review WITH CHECK ADD CONSTRAINT FK_Review_Product FOREIGN KEY(productID) REFERENCES Product (id);
ALTER TABLE Review CHECK CONSTRAINT FK_Review_Product;

ALTER TABLE SoLuongDaBan WITH CHECK ADD CONSTRAINT FK_SoLuongDaBan_Product FOREIGN KEY(productID) REFERENCES Product (id);
ALTER TABLE SoLuongDaBan CHECK CONSTRAINT FK_SoLuongDaBan_Product;

ALTER TABLE Supplier WITH CHECK ADD CONSTRAINT FK_Supplier_Category FOREIGN KEY(cateID) REFERENCES Category (cid);
ALTER TABLE Supplier CHECK CONSTRAINT FK_Supplier_Category;

ALTER TABLE TongChiTieuBanHang WITH CHECK ADD CONSTRAINT FK_TongChiTieuBanHang_Account FOREIGN KEY(userID) REFERENCES Account (uID);
ALTER TABLE TongChiTieuBanHang CHECK CONSTRAINT FK_TongChiTieuBanHang_Account;
