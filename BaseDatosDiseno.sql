USE [Diseño]
GO
/****** Object:  Table [dbo].[Actividad]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Actividad](
	[IdActividad] [int] IDENTITY(1,1) NOT NULL,
	[IdTarea] [varchar](50) NULL,
	[FechaCreacion] [date] NULL,
	[FechaCompletado] [date] NULL,
	[FechaUltimaModificacion] [date] NULL,
	[NombreTarea] [varchar](50) NULL,
	[IdUsuario] [Int] NULL,
	[EmailAsignado] [varchar](50) NULL,
	[FechaInicio] [date] NULL,
	[FechaFin] [date] NULL,
	[Etiqueta] [varchar](50) NULL,
	[Nota] [varchar](50) NULL,
	[IdProyecto] [Int] NULL,
	[TareaPadre] [varchar](50) NULL,
 CONSTRAINT [PK_Actividad] PRIMARY KEY CLUSTERED 
(
	[IdActividad] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Avance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Avance](
	[IdAvance] [int] IDENTITY(1,1) NOT NULL,
	[IdActividad] [int] NULL,
	[FechaAvance] [date] NULL,
	[HorasDedicadas] [int] NULL,
	[TipoAvance] [int] NULL,
	[Descripción] [varchar](500) NULL,
 CONSTRAINT [PK_Avance] PRIMARY KEY CLUSTERED 
(
	[IdAvance] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Evidencia]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Evidencia](
	[IdEvidencia] [int] IDENTITY(1,1) NOT NULL,
	[IdAvance] [int] NULL,
	[Imagen] [image] NULL,
 CONSTRAINT [PK_Evidencia] PRIMARY KEY CLUSTERED 
(
	[IdEvidencia] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Permisos]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Permisos](
	[IdPermiso] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
 CONSTRAINT [PK_Permisos] PRIMARY KEY CLUSTERED 
(
	[IdPermiso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PermisoUsuarios]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PermisoUsuarios](
	[IdPermisoUsuario] [int] IDENTITY(1,1) NOT NULL,
	[IdUsuarios] [int] NULL,
	[IdPermiso] [int] NULL,
 CONSTRAINT [PK_PermisoUsuarios] PRIMARY KEY CLUSTERED 
(
	[IdPermisoUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Proyecto]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proyecto](
	[IdProyecto] [int] IDENTITY(1,1) NOT NULL,
	[NombreProyecto] [varchar](50) NULL,
	[CodigoProyecto] [varchar](50) NULL,
 CONSTRAINT [PK_Proyecto] PRIMARY KEY CLUSTERED 
(
	[IdProyecto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Rol]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rol](
	[IdRol] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
 CONSTRAINT [PK_Rol] PRIMARY KEY CLUSTERED 
(
	[IdRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[RolUsuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[RolUsuario](
	[IdRolUsuario] [int] IDENTITY(1,1) NOT NULL,
	[IdUsuario] [int] NULL,
	[IdRol] [int] NULL,
 CONSTRAINT [PK_RolUsuario] PRIMARY KEY CLUSTERED 
(
	[IdRolUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipoAvance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoAvance](
	[IdTipoAvance] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
 CONSTRAINT [PK_TipoAvance] PRIMARY KEY CLUSTERED 
(
	[IdTipoAvance] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[IdUsuario] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [varchar](50) NULL,
	[Correo] [varchar](50) NULL,
	[CodigoUsuario] [varchar](50) NULL,
	[Contrasena] [varchar](50) NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[IdUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Actividad]  WITH CHECK ADD  CONSTRAINT [FK_Actividad_Usuario] FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[Usuario] ([IdUsuario])
GO
ALTER TABLE [dbo].[Actividad]  WITH CHECK ADD  CONSTRAINT [FK_Actividad_Proyecto] FOREIGN KEY([IdProyecto])
REFERENCES [dbo].[Proyecto] ([IdProyecto])
GO
ALTER TABLE [dbo].[Avance]  WITH CHECK ADD  CONSTRAINT [FK_Avance_Actividad] FOREIGN KEY([IdActividad])
REFERENCES [dbo].[Actividad] ([IdActividad])
GO
ALTER TABLE [dbo].[Avance] CHECK CONSTRAINT [FK_Avance_Actividad]
GO
ALTER TABLE [dbo].[Avance]  WITH CHECK ADD  CONSTRAINT [FK_Avance_TipoAvance] FOREIGN KEY([TipoAvance])
REFERENCES [dbo].[TipoAvance] ([IdTipoAvance])
GO
ALTER TABLE [dbo].[Avance] CHECK CONSTRAINT [FK_Avance_TipoAvance]
GO
ALTER TABLE [dbo].[Evidencia]  WITH CHECK ADD  CONSTRAINT [FK_Evidencia_Avance] FOREIGN KEY([IdAvance])
REFERENCES [dbo].[Avance] ([IdAvance])
GO
ALTER TABLE [dbo].[Evidencia] CHECK CONSTRAINT [FK_Evidencia_Avance]
GO
ALTER TABLE [dbo].[PermisoUsuarios]  WITH CHECK ADD  CONSTRAINT [FK_PermisoUsuarios_Permisos] FOREIGN KEY([IdPermiso])
REFERENCES [dbo].[Permisos] ([IdPermiso])
GO
ALTER TABLE [dbo].[PermisoUsuarios] CHECK CONSTRAINT [FK_PermisoUsuarios_Permisos]
GO
ALTER TABLE [dbo].[PermisoUsuarios]  WITH CHECK ADD  CONSTRAINT [FK_PermisoUsuarios_Usuario] FOREIGN KEY([IdUsuarios])
REFERENCES [dbo].[Usuario] ([IdUsuario])
GO
ALTER TABLE [dbo].[PermisoUsuarios] CHECK CONSTRAINT [FK_PermisoUsuarios_Usuario]
GO
ALTER TABLE [dbo].[RolUsuario]  WITH CHECK ADD  CONSTRAINT [FK_RolUsuario_Rol] FOREIGN KEY([IdRol])
REFERENCES [dbo].[Rol] ([IdRol])
GO
ALTER TABLE [dbo].[RolUsuario] CHECK CONSTRAINT [FK_RolUsuario_Rol]
GO
ALTER TABLE [dbo].[RolUsuario]  WITH CHECK ADD  CONSTRAINT [FK_RolUsuario_Usuario] FOREIGN KEY([IdUsuario])
REFERENCES [dbo].[Usuario] ([IdUsuario])
GO
ALTER TABLE [dbo].[RolUsuario] CHECK CONSTRAINT [FK_RolUsuario_Usuario]
GO
/****** Object:  StoredProcedure [dbo].[actualizarActividad]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarActividad]
	-- Add the parameters for the stored procedure here
	@idActividad int,
	@idTarea varchar(50),
	@fechaCreacion date,
	@fechaCompletado date,
	@fechaUltimaModificacion date,
	@nombreTarea varchar(50),
	@idUsuario varchar(50),
	@emailAsignado varchar(50),
	@fechaInicio date,
	@fechaFin date,
	@etiqueta varchar(50),
	@nota varchar(50),
	@idProyecto varchar(50),
	@tareaPadre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[Actividad]
	   SET [IdTarea] = @idTarea
		  ,[FechaCreacion] = @fechaCreacion
		  ,[FechaCompletado] = @fechaCompletado
		  ,[FechaUltimaModificacion] = @fechaUltimaModificacion
		  ,[NombreTarea] = @nombreTarea
		  ,[IdUsuario] = @idUsuario
		  ,[EmailAsignado] = @emailAsignado
		  ,[FechaInicio] = @fechaInicio
		  ,[FechaFin] = @fechaFin
		  ,[Etiqueta] = @etiqueta
		  ,[Nota] = @nota
		  ,[IdProyecto] = @idProyecto
		  ,[TareaPadre] = @tareaPadre
	 WHERE [IdActividad] = @idActividad
END
GO
/****** Object:  StoredProcedure [dbo].[actualizarAvance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarAvance]
	-- Add the parameters for the stored procedure here
	@idAvance int,
	@idActividad int,
	@fechaAvance date,
	@horasDedicadas int,
	@tipoAvance int,
	@descripcion varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[Avance]
	   SET [IdActividad] = @idActividad
           ,[FechaAvance] = @fechaAvance
           ,[HorasDedicadas] = @horasDedicadas
           ,[TipoAvance] = @tipoAvance
           ,[Descripción] = @descripcion
	 WHERE [IdAvance] = @idAvance
END
GO
/****** Object:  StoredProcedure [dbo].[actualizarEvidencia]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarEvidencia]
	-- Add the parameters for the stored procedure here
	@idEvidencia int,
	@idAvance int,
	@imagen image
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[Evidencia]
	   SET [IdAvance] = @idAvance
           ,[Imagen] = @imagen
	 WHERE [IdEvidencia] = @idEvidencia
END
GO
/****** Object:  StoredProcedure [dbo].[actualizarPermiso]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarPermiso]
	-- Add the parameters for the stored procedure here
	@idPermiso int,
	@nombre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[Permisos]
	   SET [Nombre] = @nombre
	 WHERE [IdPermiso] = @idPermiso
END
GO
/****** Object:  StoredProcedure [dbo].[actualizarPermisoUsuarios]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarPermisoUsuarios]
	-- Add the parameters for the stored procedure here
	@idPermisoUsuarios int,
	@idUsuario int,
	@idPermiso int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[PermisoUsuarios]
	   SET [IdUsuarios] = @idUsuario
		  ,[IdPermiso] = @idPermiso
	 WHERE [IdPermisoUsuario] = @idPermisoUsuarios
END
GO
/****** Object:  StoredProcedure [dbo].[actualizarProyecto]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarProyecto]
	-- Add the parameters for the stored procedure here
	@codigoProyecto int,
	@nombreProyecto varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[Proyecto]
	   SET [NombreProyecto] = @nombreProyecto
	 WHERE [CodigoProyecto] = @codigoProyecto
END
GO
/****** Object:  StoredProcedure [dbo].[actualizarRol]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarRol]
	-- Add the parameters for the stored procedure here
	@idRol int,
	@nombre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[Rol]
	   SET [Nombre] = @nombre
	 WHERE [IdRol] = @idRol
END
GO
/****** Object:  StoredProcedure [dbo].[actualizarRolUsuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarRolUsuario]
	-- Add the parameters for the stored procedure here
	@idRolUsuario int,
	@idUsuario int,
	@idRol int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[RolUsuario]
	   SET [IdUsuario] = @idUsuario
		  ,[IdRol] = @idRol
	 WHERE [IdRolUsuario] = @idRolUsuario
END
GO
/****** Object:  StoredProcedure [dbo].[actualizarTipoAvance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarTipoAvance]
	-- Add the parameters for the stored procedure here
	@idTipoAvance int,
	@nombre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[TipoAvance]
	   SET [Nombre] = @nombre
	 WHERE [IdTipoAvance] = @idTipoAvance
END
GO
/****** Object:  StoredProcedure [dbo].[actualizarUsuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[actualizarUsuario]
	-- Add the parameters for the stored procedure here
	@idUsuario int,
	@nombre varchar(50),
	@correo varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	UPDATE [dbo].[Usuario]
	   SET [Nombre] = @nombre
		  ,[Correo] = @correo
	 WHERE [IdUsuario] = @idUsuario
END
GO
/****** Object:  StoredProcedure [dbo].[borrarActividad]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarActividad]
	-- Add the parameters for the stored procedure here
	@idActividad int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[Actividad]
	 WHERE [IdActividad] = @idActividad
END
GO
/****** Object:  StoredProcedure [dbo].[borrarAvance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarAvance]
	-- Add the parameters for the stored procedure here
	@idAvance int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[Avance]
	 WHERE [IdAvance] = @idAvance
END
GO
/****** Object:  StoredProcedure [dbo].[borrarEvidencia]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarEvidencia]
	-- Add the parameters for the stored procedure here
	@idEvidencia int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[Evidencia]
	 WHERE [IdEvidencia] = @idEvidencia
END
GO
/****** Object:  StoredProcedure [dbo].[borrarPermiso]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarPermiso]
	-- Add the parameters for the stored procedure here
	@idPermiso int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[Permisos]
	 WHERE [IdPermiso] = @idPermiso
END
GO
/****** Object:  StoredProcedure [dbo].[borrarPermisoUsuarios]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarPermisoUsuarios]
	-- Add the parameters for the stored procedure here
	@idPermisoUsuarios int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[PermisoUsuarios]
	 WHERE [IdPermisoUsuario] = @idPermisoUsuarios
END
GO
/****** Object:  StoredProcedure [dbo].[borrarProyecto]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarProyecto]
	-- Add the parameters for the stored procedure here
	@codigoProyecto int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[Proyecto]
	 WHERE [CodigoProyecto] = @codigoProyecto
END
GO
/****** Object:  StoredProcedure [dbo].[borrarRol]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarRol]
	-- Add the parameters for the stored procedure here
	@idRol int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[Rol]
	 WHERE [IdRol] = @idRol
END
GO
/****** Object:  StoredProcedure [dbo].[borrarRolUsuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarRolUsuario]
	-- Add the parameters for the stored procedure here
	@idRolUsuario int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[RolUsuario]
	 WHERE [IdRolUsuario] = @idRolUsuario
END
GO
/****** Object:  StoredProcedure [dbo].[borrarTipoAvance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarTipoAvance]
	-- Add the parameters for the stored procedure here
	@idTipoAvance int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[TipoAvance]
	 WHERE [IdTipoAvance] = @idTipoAvance
END
GO
/****** Object:  StoredProcedure [dbo].[borrarUsuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[borrarUsuario]
	-- Add the parameters for the stored procedure here
	@idUsuario int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	DELETE FROM [dbo].[Usuario]
	 WHERE [IdUsuario] = @idUsuario
END
GO
/****** Object:  StoredProcedure [dbo].[insertarActividad]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarActividad]
	-- Add the parameters for the stored procedure here
	@idTarea varchar(50),
	@fechaCreacion date,
	@fechaCompletado date,
	@fechaUltimaModificacion date,
	@nombreTarea varchar(50),
	@idUsuario varchar(50),
	@emailAsignado varchar(50),
	@fechaInicio date,
	@fechaFin date,
	@etiqueta varchar(50),
	@nota varchar(50),
	@idProyecto varchar(50),
	@tareaPadre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	DECLARE @IdenUsuario int
	DECLARE @IdenProyecto int

	SELECT @IdenUsuario=U.IdUsuario
	FROM Usuario U
	WHERE U.CodigoUsuario = @idUsuario 

	SELECT @IdenProyecto = P.IdProyecto
	FROM Proyecto P
	WHERE P.CodigoProyecto = @idProyecto

    -- Insert statements for procedure here
	INSERT INTO [dbo].[Actividad]
			   ([IdTarea]
			   ,[FechaCreacion]
			   ,[FechaCompletado]
			   ,[FechaUltimaModificacion]
			   ,[NombreTarea]
			   ,[IdUsuario]
			   ,[EmailAsignado]
			   ,[FechaInicio]
			   ,[FechaFin]
			   ,[Etiqueta]
			   ,[Nota]
			   ,[IdProyecto]
			   ,[TareaPadre])
		 VALUES
			   (@IdTarea,
			   @FechaCreacion,
			   @FechaCompletado,
			   @FechaUltimaModificacion,
			   @NombreTarea,
			   @IdenUsuario,
			   @EmailAsignado,
			   @FechaInicio,
			   @FechaFin,
			   @Etiqueta,
			   @Nota,
			   @IdenProyecto,
			   @TareaPadre)
END
GO
/****** Object:  StoredProcedure [dbo].[insertarAvance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarAvance]
	-- Add the parameters for the stored procedure here
	@idActividad int,
	@fechaAvance date,
	@horasDedicadas int,
	@tipoAvance int,
	@descripcion varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO [dbo].[Avance]
			   ([IdActividad]
			   ,[FechaAvance]
			   ,[HorasDedicadas]
			   ,[TipoAvance]
			   ,[Descripción])
		 VALUES
			   (@idActividad,
				@fechaAvance,
				@horasDedicadas,
				@tipoAvance,
				@descripcion)
END
GO
/****** Object:  StoredProcedure [dbo].[insertarEvidencia]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarEvidencia]
	-- Add the parameters for the stored procedure here
	@idAvance int,
	@imagen image
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO [dbo].[Evidencia]
			   ([IdAvance]
			   ,[Imagen])
		 VALUES
			   (@idAvance,
				@imagen)
END
GO
/****** Object:  StoredProcedure [dbo].[insertarPermiso]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarPermiso]
	-- Add the parameters for the stored procedure here
	@idPermiso int,
	@nombre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO [dbo].[Permisos]
			   ([IdPermiso]
			   ,[Nombre])
		 VALUES
			   (@idPermiso,
			   @nombre)
END
GO
/****** Object:  StoredProcedure [dbo].[insertarPermisoUsuarios]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarPermisoUsuarios]
	-- Add the parameters for the stored procedure here
	@idUsuario int,
	@idPermiso int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO [dbo].[PermisoUsuarios]
			   ([IdUsuarios]
			   ,[IdPermiso])
		 VALUES
			   (@idUsuario,
			   @idPermiso)
END
GO
/****** Object:  StoredProcedure [dbo].[insertarProyecto]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarProyecto]
	-- Add the parameters for the stored procedure here
	@nombreProyecto varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO [dbo].[Proyecto]
			   ([NombreProyecto])
		 VALUES
			   (@nombreProyecto)
END
GO
/****** Object:  StoredProcedure [dbo].[insertarRol]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarRol]
	-- Add the parameters for the stored procedure here
	@nombre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO [dbo].[Rol]
			   ([Nombre])
		 VALUES
			   (@nombre)
END
GO
/****** Object:  StoredProcedure [dbo].[insertarRolUsuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarRolUsuario]
	-- Add the parameters for the stored procedure here
	@idUsuario int,
	@idRol int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO [dbo].[RolUsuario]
			   ([IdUsuario]
			   ,[IdRol])
		 VALUES
			   (@idUsuario,
			   @idRol)
END
GO
/****** Object:  StoredProcedure [dbo].[insertarTipoAvance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarTipoAvance]
	-- Add the parameters for the stored procedure here
	@nombre varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO [dbo].[TipoAvance]
			   ([Nombre])
		 VALUES
			   (@nombre)
END
GO
/****** Object:  StoredProcedure [dbo].[insertarUsuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[insertarUsuario]
	-- Add the parameters for the stored procedure here
	@nombre varchar(50),
	@correo varchar(50)
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	INSERT INTO [dbo].[Usuario]
			   ([Nombre]
			   ,[Correo])
		 VALUES
			   (@nombre,
			   @correo)
END
GO
/****** Object:  StoredProcedure [dbo].[leerActividad]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerActividad]
	-- Add the parameters for the stored procedure here
	@idActividad int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [IdTarea]
		  ,[FechaCreacion]
		  ,[FechaCompletado]
		  ,[FechaUltimaModificacion]
		  ,[NombreTarea]
		  ,[IdUsuario]
		  ,[EmailAsignado]
		  ,[FechaInicio]
		  ,[FechaFin]
		  ,[Etiqueta]
		  ,[Nota]
		  ,[IdProyecto]
		  ,[TareaPadre]
	  FROM [dbo].[Actividad]
	  WHERE [IdActividad] = @idActividad
END
GO
/****** Object:  StoredProcedure [dbo].[leerAvance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerAvance]
	-- Add the parameters for the stored procedure here
	@idAvance int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [IdActividad]
           ,[FechaAvance]
           ,[HorasDedicadas]
           ,[TipoAvance]
           ,[Descripción]
	  FROM [dbo].[Avance]
	  WHERE [IdAvance] = @idAvance
END
GO
/****** Object:  StoredProcedure [dbo].[leerEvidencia]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerEvidencia]
	-- Add the parameters for the stored procedure here
	@idEvidencia int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [IdAvance]
           ,[Imagen]
	  FROM [dbo].[Evidencia]
	  WHERE [IdEvidencia] = @idEvidencia
END
GO
/****** Object:  StoredProcedure [dbo].[leerPermiso]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerPermiso]
	-- Add the parameters for the stored procedure here
	@idPermiso int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [Nombre]
	  FROM [dbo].[Permisos]
	  WHERE [IdPermiso] = @idPermiso
END
GO
/****** Object:  StoredProcedure [dbo].[leerPermisoUsuarios]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerPermisoUsuarios]
	-- Add the parameters for the stored procedure here
	@idPermisoUsuarios int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [IdUsuarios]
           ,[IdPermiso]
	  FROM [dbo].[PermisoUsuarios]
	  WHERE [IdPermisoUsuario] = @idPermisoUsuarios
END
GO
/****** Object:  StoredProcedure [dbo].[leerProyecto]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerProyecto]
	-- Add the parameters for the stored procedure here
	@codigoProyecto int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [NombreProyecto]
	  FROM [dbo].[Proyecto]
	  WHERE CodigoProyecto = @codigoProyecto
END
GO
/****** Object:  StoredProcedure [dbo].[leerRol]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerRol]
	-- Add the parameters for the stored procedure here
	@idRol int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [Nombre]
	  FROM [dbo].[Rol]
	  WHERE [IdRol] = @idRol
END
GO
/****** Object:  StoredProcedure [dbo].[leerRolUsuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerRolUsuario]
	-- Add the parameters for the stored procedure here
	@idRolUsuario int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [IdUsuario]
		  ,[IdRol]
	  FROM [dbo].[RolUsuario]
	  WHERE [IdRolUsuario] = @idRolUsuario
END
GO
/****** Object:  StoredProcedure [dbo].[leerTipoAvance]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerTipoAvance]
	-- Add the parameters for the stored procedure here
	@idTipoAvance int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [Nombre]
	  FROM [dbo].[TipoAvance]
	  WHERE [IdTipoAvance] = @idTipoAvance
END
GO
/****** Object:  StoredProcedure [dbo].[leerUsuario]    Script Date: 2/6/2019 22:23:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[leerUsuario]
	-- Add the parameters for the stored procedure here
	@idUsuario int
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;

    -- Insert statements for procedure here
	SELECT [Nombre]
		  ,[Correo]
	  FROM [dbo].[Usuario]
	  WHERE [IdUsuario] = @idUsuario
END
GO
