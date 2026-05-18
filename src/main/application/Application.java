package application;

import runtimeSE.Runner;

import runtimeSE.RuntimeSE;

import runtimeSE.Runner.Accessors;

/**

 * Class with {@code main()} method as entry point for the Java VM.

 * @version <code style=color:green>{@value application.package_info#Version}</code>

 * @author <code style=color:blue>{@value application.package_info#Author}</code>

 */

@Accessors(priority=0)

public class Application implements Runner {

    public static void main(String[] args) {

        RuntimeSE.getInstance().startup(args);

    }

    @Override

    public void run(RuntimeSE runtime, String[] args) {

        String applicationName = runtime.properties().getProperty(

            "application.name",

            "unknown (no 'application.name' property)"

        );

        String applicationVersion = runtime.properties().getProperty(

            "application.version",

            "unknown version (no 'application.version' property)"

        );

        String greeting = String.format(

            "Hello, %s (version %s)",

            applicationName,

            applicationVersion

        );

        System.out.println(greeting);

        for (String arg : args) {

            String output = String.format(" - arg: %s", arg);

            System.out.println(output);

        }

    }

}
