Process poc = 'cmd /c date'.execute()

Thread.start {System.out << poc.in}
Thread.start {System.err << poc.err}


poc << "no such date" << "\n"
poc << '2013-8-20' << "\n"

poc.out.close()
poc.waitForOrKill(0)
