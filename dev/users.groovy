import companyname.*
/*
# This file defines the users that have access to the Jenkins server, folders and their permissions.
# You can specify permissions for unauthenticated users by using the "anonymous" username
#
# The following permissions are available on Jenkins:
#  hudson.model.Hudson.Administer,
#  hudson.model.Hudson.ConfigureUpdateCenter,
#  hudson.model.Hudson.Read,
#  hudson.model.Hudson.RunScripts,
#  hudson.model.Hudson.UploadPlugins,
#  hudson.model.Computer.Build,
#  hudson.model.Computer.Build,
#  hudson.model.Computer.Configure,
#  hudson.model.Computer.Connect,
#  hudson.model.Computer.Create,
#  hudson.model.Computer.Delete,
#  hudson.model.Computer.Disconnect,
#  hudson.model.Run.Delete,
#  hudson.model.Run.Update,
#  hudson.model.View.Configure,
#  hudson.model.View.Create,
#  hudson.model.View.Read,
#  hudson.model.View.Delete,
#  hudson.model.Item.Create,
#  hudson.model.Item.Delete,
#  hudson.model.Item.Configure,
#  hudson.model.Item.Read,
#  hudson.model.Item.Discover,
#  hudson.model.Item.Build,
#  hudson.model.Item.Workspace,
#  hudson.model.Item.Cancel
#
# Make it easy on us and list your username in alphabetical order.
*/

def user_permissions = [

        //TODO: this is definitely not something you'll do in production, it's just so that you can validate the
        //DSL worked correctly in Vagrant, 'hudson.model.Hudson.Read' makes a bit more sense.
        'anonymous': ['hudson.model.Hudson.Administer'],

        'alice.name': ['hudson.model.Hudson.Administer'],
        'bob12': ['hudson.model.Hudson.Read', 'hudson.model.Item.Build', 'hudson.model.Item.Workspace'],
        'char.lie': ['hudson.model.Hudson.Read', 'hudson.model.Item.Build',]
]

Utilities.populateUserAuthorization(out, user_permissions)