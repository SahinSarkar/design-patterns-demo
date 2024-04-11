Of course, let's try a different context that involves enhancing system functionality rather than price calculation:

# Title: User Role Management System

Dear Candidate,

Our software has a modular role management system for users. Depending on their roles, users possess different system permissions. The permissions can be viewed as a set of basic conditions (no permissions) which can be decorated with additional role-specific permissions.

**Basic Set Up:**

- The base user will be a "Guest" who has read-only access
- The specific roles are:
    - "Member", who in addition to Guest permissions can create content
    - "Moderator", who in addition to Member permissions can edit and delete content of other users
    - "Admin", who in addition to Moderator permissions can manage user roles

A user can have a combination of roles. For example, one could be both a Moderator and an Admin.

**Specific Requirements:**

1. Your implementation should enable the assignment of one or multiple roles to a user and it should dynamically modify user permissions based on the assigned roles.
2. It should be possible to add and remove permissions from a user at runtime.
3. The system should allow checking if a user has a specific permission.
4. The design must follow the decorator pattern principles. It should be easy to add new roles or adjust permissions attached to each role without changing existing code.

Please note that this assignment does not necessarily require you to implement an actual user interface or database layer. We mainly focus on the implementation of the delineated roles using the decorator pattern.

Good luck with the assignment, we're looking forward to review your solution.

Best,  
[Your Name]

Please replace "[Your Name]" with your real
