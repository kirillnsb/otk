function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }

    return -1;
}


var typeApi = Vue.resource('/types{/id}');

Vue.component('types-form', {
    props: ['types', 'typeAttr'],
    data: function() {
        return {
            typeName: '',
            description: '',
            id: ''
        }
    },
    watch: {
        typeAttr: function(newVal, oldVal) {
            this.typeName = newVal.typeName;
            this.description = newVal.description;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="Type name" v-model="typeName" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var type = { typeName: this.typeName };

            if (this.id) {
                typeApi.update({id: this.id}, type).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.types, data.id);
                        this.types.splice(index, 1, data);
                        this.typeName = ''
                        this.id = ''
                    })
                )
            } else {
                typeApi.save({}, type).then(result =>
                    result.json().then(data => {
                        this.types.push(data);
                        this.typeName = ''
                    })
                )
            }
        }
    }
});

Vue.component('type-row', {
    props: ['type', 'editMethod', 'types'],
    template: '<div>' +
        '<i>({{ type.id }})</i> {{ type.typeName }} - {{ type.description }}' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="Edit" @click="edit" />' +
        '<input type="button" value="X" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        edit: function() {
            this.editMethod(this.type);
        },
        del: function() {
            typeApi.remove({id: this.type.id}).then(result => {
                if (result.ok) {
                    this.types.splice(this.types.indexOf(this.type), 1)
                }
            })
        }
    }
});

Vue.component('types-list', {
    props: ['types'],
    data: function() {
        return {
            type: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<type-form :types="types" :typeAttr="type" />' +
        '<type-row v-for="type in types" :key="type.id" :type="type" ' +
        ':editMethod="editMethod" :types="types" />' +
        '</div>',
    created: function() {
        typeApi.get().then(result =>
            result.json().then(data =>
                data.forEach(type => this.types.push(type))
            )
        )
    },
    methods: {
        editMethod: function(type) {
            this.type = type;
        }
    }
});

var app1 = new Vue({
    el: '#app1',
    template: '<types-list :types="types" />',
    data: {
        types: []
    }
});