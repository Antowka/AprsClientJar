##For start this jar file how service on VPS or any server##

1) Create empty file in path: */etc/init.d*
   
   ```
    sudo vi /etc/init.d/aprsclient
   ``` 
    
2) Add shell script:
    
    ```bash
        #!/bin/sh
        SERVICE_NAME=aprsclient
        PATH_TO_JAR=/var/www/scripts/aprs-client.jar
        PID_PATH_NAME=/tmp/aprsclient-pid
        case $1 in
            start)
                echo "Starting $SERVICE_NAME ..."
                if [ ! -f $PID_PATH_NAME ]; then
                    nohup java -jar $PATH_TO_JAR /tmp 2>> /dev/null >> /dev/null &
                                echo $! > $PID_PATH_NAME
                    echo "$SERVICE_NAME started ..."
                else
                    echo "$SERVICE_NAME is already running ..."
                fi
            ;;
            stop)
                if [ -f $PID_PATH_NAME ]; then
                    PID=$(cat $PID_PATH_NAME);
                    echo "$SERVICE_NAME stoping ..."
                    kill $PID;
                    echo "$SERVICE_NAME stopped ..."
                    rm $PID_PATH_NAME
                else
                    echo "$SERVICE_NAME is not running ..."
                fi
            ;;
            restart)
                if [ -f $PID_PATH_NAME ]; then
                    PID=$(cat $PID_PATH_NAME);
                    echo "$SERVICE_NAME stopping ...";
                    kill $PID;
                    echo "$SERVICE_NAME stopped ...";
                    rm $PID_PATH_NAME
                    echo "$SERVICE_NAME starting ..."
                    nohup java -jar $PATH_TO_JAR /tmp 2>> /dev/null >> /dev/null &
                                echo $! > $PID_PATH_NAME
                    echo "$SERVICE_NAME started ..."
                else
                    echo "$SERVICE_NAME is not running ..."
                fi
            ;;
        esac 
    ```
        
    
2) Set permission on files:

   ```bash
        chmod -R 0755 /etc/init.d/aprsclient
        chmod -R 0755 /var/www/scripts/aprs-client.jar
        chmod -X /etc/init.d/aprsclient
        chmod -X /var/www/scripts/aprs-client.jar
   ```
    
    