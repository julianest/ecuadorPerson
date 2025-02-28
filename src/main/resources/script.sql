-- Creación de la tabla de Usuarios
CREATE TABLE Usuarios (
    id IDENTITY PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255) NOT NULL,
    telefono VARCHAR(15) NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    estado BOOLEAN NOT NULL
);

-- Inserción de Usuarios
INSERT INTO Usuarios (nombre, direccion, telefono, contrasena, estado) VALUES
('Jose Lema', 'Otavalo sn y principal', '098254785', '1234', TRUE),
('Marianela Montalvo', 'Amazonas y NNUU', '097548965', '5678', TRUE),
('Juan Osorio', '13 junio y Equinoccial', '098874587', '1245', TRUE);

-- Creación de la tabla de Cuentas
CREATE TABLE Cuentas (
    id IDENTITY PRIMARY KEY,
    numero_cuenta VARCHAR(20) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    saldo DECIMAL(10,2) NOT NULL,
    estado BOOLEAN NOT NULL,
    usuario_id INT,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);

-- Inserción de Cuentas de Usuario
INSERT INTO Cuentas (numero_cuenta, tipo, saldo, estado, usuario_id) VALUES
('478758', 'Ahorro', 2000, TRUE, (SELECT id FROM Usuarios WHERE nombre = 'Jose Lema')),
('225487', 'Corriente', 100, TRUE, (SELECT id FROM Usuarios WHERE nombre = 'Marianela Montalvo')),
('495878', 'Ahorros', 0, TRUE, (SELECT id FROM Usuarios WHERE nombre = 'Juan Osorio')),
('496825', 'Ahorros', 540, TRUE, (SELECT id FROM Usuarios WHERE nombre = 'Marianela Montalvo'));

-- Creación de nueva cuenta corriente para Jose Lema
INSERT INTO Cuentas (numero_cuenta, tipo, saldo, estado, usuario_id) VALUES
('585545', 'Corriente', 1000, TRUE, (SELECT id FROM Usuarios WHERE nombre = 'Jose Lema'));

-- Creación de la tabla de Movimientos
CREATE TABLE Movimientos (
    id IDENTITY PRIMARY KEY,
    cuenta_id INT,
    fecha DATE NOT NULL,
    tipo_movimiento VARCHAR(50) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    saldo_disponible DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (cuenta_id) REFERENCES Cuentas(id)
);

-- Inserción de Movimientos
INSERT INTO Movimientos (cuenta_id, fecha, tipo_movimiento, monto, saldo_disponible) VALUES
((SELECT id FROM Cuentas WHERE numero_cuenta = '478758'), '2022-02-10', 'Retiro', -575, 1425),
((SELECT id FROM Cuentas WHERE numero_cuenta = '225487'), '2022-02-10', 'Deposito', 600, 700),
((SELECT id FROM Cuentas WHERE numero_cuenta = '495878'), '2022-02-08', 'Deposito', 150, 150),
((SELECT id FROM Cuentas WHERE numero_cuenta = '496825'), '2022-02-08', 'Retiro', -540, 0);
