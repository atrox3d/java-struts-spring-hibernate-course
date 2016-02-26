for folder in $(cat /etc/passwd | awk -F ":" '{print $6}') 
do 
    if [ -d "$folder" ]
        then user=$(cat /etc/passwd | grep $folder | awk -F ":" '{ print $1}') 
        echo "$folder,$(stat -c "%a" $folder),$(echo $user),$(id -u $user),$(id -g $user)" 
    fi
done

