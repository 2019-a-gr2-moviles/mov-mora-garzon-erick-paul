/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombreAtributo: {
      type:'string'
    },
    nombre: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 60,
    },
    cedula: {
      type: 'string',
      required: true,
      unique: true,
      minLength: 10,
      maxLength: 25,
    },
    username: {
      type: 'string',
      required: true,
      unique: true
    },
    fechaNacimiento: {
      type: 'string'
    },
    sueldo: {
      type: 'number',
      min: 100.00,
      max: 5000,
      defaultsTo: 100.00
    },
    estaCasado: {
      type: 'boolean',
      defaultsTo: false
    },
    latitudCasa: {
      type: 'string'
    },
    longitudCasa: {
      type: 'string'
    },
    tipoUsuario: {
      type: 'string',
      enum: ['normal', 'pendiente', 'premium']
    },
    correo: {
      type: 'string',
      isEmail: true
    }
  },

};

// http://localhost:1337/usuario

//Estandar restful

//Crear
//http://localhost:1337/usuario
//Metodo HTTP: POST
//Body Params: usuario


//Actualizar
//http://localhost:1337/usuario/:id
//Ej: http://localhost:1337/usuario/2
//Metodo HTTP: PUT
//Body Params: usuario



//Borrar
//http://localhost:1337/usuario/:id
//Ej: http://localhost:1337/usuario/2
//Metodo HTTP: DELETE



//Buscar por id
//http://localhost:1337/usuario/:id
//Ej: http://localhost:1337/usuario/2
//Metodo HTTP: GET

//Obtener todos (enviar parametros busqueda)
//http://localhost:1337/usuario/:id
//Ej: http://localhost:1337/usuario/2
//Metodo HTTP: GET


//ejemplos
//1) buscar al usuario con nombre Paul
//http://localhost:1337/usuario?nombre=Paul

//2) buscar al usuario con nombre Paul y cedula 1745583253
//http://localhost:1337/usuario?nombre=Paul&cedula=1745583253

//3) traer los primeros 5
//http://localhost:1337/usuario?limit=5

//4) traer los primeros 5 despues de los primeros 10
//http://localhost:1337/usuario?limit=5&skip=10


//5) traer los registros ordenados por nombre
//http://localhost:1337/usuario?sort=nombre
//http://localhost:1337/usuario?sort=nombre DESC
//http://localhost:1337/usuario?sort=nombre ASC

//6) traer los registros que contengan en el nombre la letra a
//http://localhost:1337/usuario?where={"nombre":{"contains":"a"}}
//sueldo
//http://localhost:1337/usuario?where={"sueldo":{"<=":"3000"}}
//fechaNacimiento
//http://localhost:1337/usuario?where={"fechaNacimiento":{"<=":"2018-01-01"}}
//correo
//http://localhost:1337/usuario?where={"correo":{"endsWith":"@gmail.com"}}



