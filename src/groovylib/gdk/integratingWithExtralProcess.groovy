Process poc = "ls".execute()
println poc.text

Process poc1 = ['cmd', '/c', 'dir', /\Program Files/].execute()
println poc1.text


