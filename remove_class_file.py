import os

# to remove the ".class" files from "client/components" folder just run the python file
folder_path = "client/components"

for filename in os.listdir(folder_path):
    if filename.endswith(".class"):
        os.remove(os.path.join(folder_path, filename))
