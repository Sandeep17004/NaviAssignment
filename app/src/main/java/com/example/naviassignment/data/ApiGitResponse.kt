package com.example.naviassignment.data

import com.google.gson.annotations.SerializedName

class ApiGitResponse(
    @SerializedName("active_lock_reason")
    val activeLockReason: String?,
    @SerializedName("additions")
    val additions: Int?,
    @SerializedName("assignee")
    val assignee: Assignee?,
    @SerializedName("assignees")
    val assignees: List<Assignee?>?,
    @SerializedName("author_association")
    val authorAssociation: String?,
    @SerializedName("auto_merge")
    val autoMerge: Any?,
    @SerializedName("base")
    val base: Base?,
    @SerializedName("body")
    val body: String?,
    @SerializedName("changed_files")
    val changedFiles: Int?,
    @SerializedName("closed_at")
    val closedAt: String?,
    @SerializedName("comments")
    val comments: Int?,
    @SerializedName("comments_url")
    val commentsUrl: String?,
    @SerializedName("commits")
    val commits: Int?,
    @SerializedName("commits_url")
    val commitsUrl: String?,
    @SerializedName("created_at")
    val createdAt: String?,
    @SerializedName("deletions")
    val deletions: Int?,
    @SerializedName("diff_url")
    val diffUrl: String?,
    @SerializedName("draft")
    val draft: Boolean?,
    @SerializedName("head")
    val head: Head?,
    @SerializedName("html_url")
    val htmlUrl: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("issue_url")
    val issueUrl: String?,
    @SerializedName("labels")
    val labels: List<Label?>?,
    @SerializedName("_links")
    val links: Links?,
    @SerializedName("locked")
    val locked: Boolean?,
    @SerializedName("maintainer_can_modify")
    val maintainerCanModify: Boolean?,
    @SerializedName("merge_commit_sha")
    val mergeCommitSha: String?,
    @SerializedName("mergeable")
    val mergeable: Boolean?,
    @SerializedName("mergeable_state")
    val mergeableState: String?,
    @SerializedName("merged")
    val merged: Boolean?,
    @SerializedName("merged_at")
    val mergedAt: String?,
    @SerializedName("merged_by")
    val mergedBy: MergedBy?,
    @SerializedName("milestone")
    val milestone: Milestone?,
    @SerializedName("node_id")
    val nodeId: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("patch_url")
    val patchUrl: String?,
    @SerializedName("rebaseable")
    val rebaseable: Boolean?,
    @SerializedName("requested_reviewers")
    val requestedReviewers: List<RequestedReviewer?>?,
    @SerializedName("requested_teams")
    val requestedTeams: List<RequestedTeam?>?,
    @SerializedName("review_comment_url")
    val reviewCommentUrl: String?,
    @SerializedName("review_comments")
    val reviewComments: Int?,
    @SerializedName("review_comments_url")
    val reviewCommentsUrl: String?,
    @SerializedName("state")
    val state: String?,
    @SerializedName("statuses_url")
    val statusesUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("user")
    val user: User?
) {
    class Assignee(
        @SerializedName("avatar_url")
        val avatarUrl: String?,
        @SerializedName("events_url")
        val eventsUrl: String?,
        @SerializedName("followers_url")
        val followersUrl: String?,
        @SerializedName("following_url")
        val followingUrl: String?,
        @SerializedName("gists_url")
        val gistsUrl: String?,
        @SerializedName("gravatar_id")
        val gravatarId: String?,
        @SerializedName("html_url")
        val htmlUrl: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("login")
        val login: String?,
        @SerializedName("node_id")
        val nodeId: String?,
        @SerializedName("organizations_url")
        val organizationsUrl: String?,
        @SerializedName("received_events_url")
        val receivedEventsUrl: String?,
        @SerializedName("repos_url")
        val reposUrl: String?,
        @SerializedName("site_admin")
        val siteAdmin: Boolean?,
        @SerializedName("starred_url")
        val starredUrl: String?,
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String?,
        @SerializedName("type")
        val type: String?,
        @SerializedName("url")
        val url: String?
    )
    class Base(
        @SerializedName("label")
        val label: String?,
        @SerializedName("ref")
        val ref: String?,
        @SerializedName("repo")
        val repo: Repo?,
        @SerializedName("sha")
        val sha: String?,
        @SerializedName("user")
        val user: User?
    ) {
        class Repo(
            @SerializedName("allow_merge_commit")
            val allowMergeCommit: Boolean?,
            @SerializedName("allow_rebase_merge")
            val allowRebaseMerge: Boolean?,
            @SerializedName("allow_squash_merge")
            val allowSquashMerge: Boolean?,
            @SerializedName("archive_url")
            val archiveUrl: String?,
            @SerializedName("archived")
            val archived: Boolean?,
            @SerializedName("assignees_url")
            val assigneesUrl: String?,
            @SerializedName("blobs_url")
            val blobsUrl: String?,
            @SerializedName("branches_url")
            val branchesUrl: String?,
            @SerializedName("clone_url")
            val cloneUrl: String?,
            @SerializedName("collaborators_url")
            val collaboratorsUrl: String?,
            @SerializedName("comments_url")
            val commentsUrl: String?,
            @SerializedName("commits_url")
            val commitsUrl: String?,
            @SerializedName("compare_url")
            val compareUrl: String?,
            @SerializedName("contents_url")
            val contentsUrl: String?,
            @SerializedName("contributors_url")
            val contributorsUrl: String?,
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("default_branch")
            val defaultBranch: String?,
            @SerializedName("deployments_url")
            val deploymentsUrl: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("disabled")
            val disabled: Boolean?,
            @SerializedName("downloads_url")
            val downloadsUrl: String?,
            @SerializedName("events_url")
            val eventsUrl: String?,
            @SerializedName("fork")
            val fork: Boolean?,
            @SerializedName("forks")
            val forks: Int?,
            @SerializedName("forks_count")
            val forksCount: Int?,
            @SerializedName("forks_url")
            val forksUrl: String?,
            @SerializedName("full_name")
            val fullName: String?,
            @SerializedName("git_commits_url")
            val gitCommitsUrl: String?,
            @SerializedName("git_refs_url")
            val gitRefsUrl: String?,
            @SerializedName("git_tags_url")
            val gitTagsUrl: String?,
            @SerializedName("git_url")
            val gitUrl: String?,
            @SerializedName("has_downloads")
            val hasDownloads: Boolean?,
            @SerializedName("has_issues")
            val hasIssues: Boolean?,
            @SerializedName("has_pages")
            val hasPages: Boolean?,
            @SerializedName("has_projects")
            val hasProjects: Boolean?,
            @SerializedName("has_wiki")
            val hasWiki: Boolean?,
            @SerializedName("homepage")
            val homepage: String?,
            @SerializedName("hooks_url")
            val hooksUrl: String?,
            @SerializedName("html_url")
            val htmlUrl: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("issue_comment_url")
            val issueCommentUrl: String?,
            @SerializedName("issue_events_url")
            val issueEventsUrl: String?,
            @SerializedName("issues_url")
            val issuesUrl: String?,
            @SerializedName("keys_url")
            val keysUrl: String?,
            @SerializedName("labels_url")
            val labelsUrl: String?,
            @SerializedName("language")
            val language: Any?,
            @SerializedName("languages_url")
            val languagesUrl: String?,
            @SerializedName("license")
            val license: License?,
            @SerializedName("merges_url")
            val mergesUrl: String?,
            @SerializedName("milestones_url")
            val milestonesUrl: String?,
            @SerializedName("mirror_url")
            val mirrorUrl: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("node_id")
            val nodeId: String?,
            @SerializedName("notifications_url")
            val notificationsUrl: String?,
            @SerializedName("open_issues")
            val openIssues: Int?,
            @SerializedName("open_issues_count")
            val openIssuesCount: Int?,
            @SerializedName("owner")
            val owner: Owner?,
            @SerializedName("permissions")
            val permissions: Permissions?,
            @SerializedName("private")
            val `private`: Boolean?,
            @SerializedName("pulls_url")
            val pullsUrl: String?,
            @SerializedName("pushed_at")
            val pushedAt: String?,
            @SerializedName("releases_url")
            val releasesUrl: String?,
            @SerializedName("size")
            val size: Int?,
            @SerializedName("ssh_url")
            val sshUrl: String?,
            @SerializedName("stargazers_count")
            val stargazersCount: Int?,
            @SerializedName("stargazers_url")
            val stargazersUrl: String?,
            @SerializedName("statuses_url")
            val statusesUrl: String?,
            @SerializedName("subscribers_url")
            val subscribersUrl: String?,
            @SerializedName("subscription_url")
            val subscriptionUrl: String?,
            @SerializedName("svn_url")
            val svnUrl: String?,
            @SerializedName("tags_url")
            val tagsUrl: String?,
            @SerializedName("teams_url")
            val teamsUrl: String?,
            @SerializedName("temp_clone_token")
            val tempCloneToken: String?,
            @SerializedName("topics")
            val topics: List<String?>?,
            @SerializedName("trees_url")
            val treesUrl: String?,
            @SerializedName("updated_at")
            val updatedAt: String?,
            @SerializedName("url")
            val url: String?,
            @SerializedName("watchers")
            val watchers: Int?,
            @SerializedName("watchers_count")
            val watchersCount: Int?
        ) {
             class License(
                @SerializedName("key")
                val key: String?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("node_id")
                val nodeId: String?,
                @SerializedName("spdx_id")
                val spdxId: String?,
                @SerializedName("url")
                val url: String?
            )

             class Owner(
                @SerializedName("avatar_url")
                val avatarUrl: String?,
                @SerializedName("events_url")
                val eventsUrl: String?,
                @SerializedName("followers_url")
                val followersUrl: String?,
                @SerializedName("following_url")
                val followingUrl: String?,
                @SerializedName("gists_url")
                val gistsUrl: String?,
                @SerializedName("gravatar_id")
                val gravatarId: String?,
                @SerializedName("html_url")
                val htmlUrl: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("login")
                val login: String?,
                @SerializedName("node_id")
                val nodeId: String?,
                @SerializedName("organizations_url")
                val organizationsUrl: String?,
                @SerializedName("received_events_url")
                val receivedEventsUrl: String?,
                @SerializedName("repos_url")
                val reposUrl: String?,
                @SerializedName("site_admin")
                val siteAdmin: Boolean?,
                @SerializedName("starred_url")
                val starredUrl: String?,
                @SerializedName("subscriptions_url")
                val subscriptionsUrl: String?,
                @SerializedName("type")
                val type: String?,
                @SerializedName("url")
                val url: String?
            )

             class Permissions(
                @SerializedName("admin")
                val admin: Boolean?,
                @SerializedName("pull")
                val pull: Boolean?,
                @SerializedName("push")
                val push: Boolean?
            )
        }

         class User(
            @SerializedName("avatar_url")
            val avatarUrl: String?,
            @SerializedName("events_url")
            val eventsUrl: String?,
            @SerializedName("followers_url")
            val followersUrl: String?,
            @SerializedName("following_url")
            val followingUrl: String?,
            @SerializedName("gists_url")
            val gistsUrl: String?,
            @SerializedName("gravatar_id")
            val gravatarId: String?,
            @SerializedName("html_url")
            val htmlUrl: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("login")
            val login: String?,
            @SerializedName("node_id")
            val nodeId: String?,
            @SerializedName("organizations_url")
            val organizationsUrl: String?,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String?,
            @SerializedName("repos_url")
            val reposUrl: String?,
            @SerializedName("site_admin")
            val siteAdmin: Boolean?,
            @SerializedName("starred_url")
            val starredUrl: String?,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String?,
            @SerializedName("type")
            val type: String?,
            @SerializedName("url")
            val url: String?
        )
    }

    class Head(
        @SerializedName("label")
        val label: String?,
        @SerializedName("ref")
        val ref: String?,
        @SerializedName("repo")
        val repo: Repo?,
        @SerializedName("sha")
        val sha: String?,
        @SerializedName("user")
        val user: User?
    ) {
        class Repo(
            @SerializedName("allow_forking")
            val allowForking: Boolean?,
            @SerializedName("allow_merge_commit")
            val allowMergeCommit: Boolean?,
            @SerializedName("allow_rebase_merge")
            val allowRebaseMerge: Boolean?,
            @SerializedName("allow_squash_merge")
            val allowSquashMerge: Boolean?,
            @SerializedName("archive_url")
            val archiveUrl: String?,
            @SerializedName("archived")
            val archived: Boolean?,
            @SerializedName("assignees_url")
            val assigneesUrl: String?,
            @SerializedName("blobs_url")
            val blobsUrl: String?,
            @SerializedName("branches_url")
            val branchesUrl: String?,
            @SerializedName("clone_url")
            val cloneUrl: String?,
            @SerializedName("collaborators_url")
            val collaboratorsUrl: String?,
            @SerializedName("comments_url")
            val commentsUrl: String?,
            @SerializedName("commits_url")
            val commitsUrl: String?,
            @SerializedName("compare_url")
            val compareUrl: String?,
            @SerializedName("contents_url")
            val contentsUrl: String?,
            @SerializedName("contributors_url")
            val contributorsUrl: String?,
            @SerializedName("created_at")
            val createdAt: String?,
            @SerializedName("default_branch")
            val defaultBranch: String?,
            @SerializedName("deployments_url")
            val deploymentsUrl: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("disabled")
            val disabled: Boolean?,
            @SerializedName("downloads_url")
            val downloadsUrl: String?,
            @SerializedName("events_url")
            val eventsUrl: String?,
            @SerializedName("fork")
            val fork: Boolean?,
            @SerializedName("forks")
            val forks: Int?,
            @SerializedName("forks_count")
            val forksCount: Int?,
            @SerializedName("forks_url")
            val forksUrl: String?,
            @SerializedName("full_name")
            val fullName: String?,
            @SerializedName("git_commits_url")
            val gitCommitsUrl: String?,
            @SerializedName("git_refs_url")
            val gitRefsUrl: String?,
            @SerializedName("git_tags_url")
            val gitTagsUrl: String?,
            @SerializedName("git_url")
            val gitUrl: String?,
            @SerializedName("has_downloads")
            val hasDownloads: Boolean?,
            @SerializedName("has_issues")
            val hasIssues: Boolean?,
            @SerializedName("has_pages")
            val hasPages: Boolean?,
            @SerializedName("has_projects")
            val hasProjects: Boolean?,
            @SerializedName("has_wiki")
            val hasWiki: Boolean?,
            @SerializedName("homepage")
            val homepage: String?,
            @SerializedName("hooks_url")
            val hooksUrl: String?,
            @SerializedName("html_url")
            val htmlUrl: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("issue_comment_url")
            val issueCommentUrl: String?,
            @SerializedName("issue_events_url")
            val issueEventsUrl: String?,
            @SerializedName("issues_url")
            val issuesUrl: String?,
            @SerializedName("keys_url")
            val keysUrl: String?,
            @SerializedName("labels_url")
            val labelsUrl: String?,
            @SerializedName("language")
            val language: Any?,
            @SerializedName("languages_url")
            val languagesUrl: String?,
            @SerializedName("license")
            val license: License?,
            @SerializedName("merges_url")
            val mergesUrl: String?,
            @SerializedName("milestones_url")
            val milestonesUrl: String?,
            @SerializedName("mirror_url")
            val mirrorUrl: String?,
            @SerializedName("name")
            val name: String?,
            @SerializedName("node_id")
            val nodeId: String?,
            @SerializedName("notifications_url")
            val notificationsUrl: String?,
            @SerializedName("open_issues")
            val openIssues: Int?,
            @SerializedName("open_issues_count")
            val openIssuesCount: Int?,
            @SerializedName("owner")
            val owner: Owner?,
            @SerializedName("permissions")
            val permissions: Permissions?,
            @SerializedName("private")
            val `private`: Boolean?,
            @SerializedName("pulls_url")
            val pullsUrl: String?,
            @SerializedName("pushed_at")
            val pushedAt: String?,
            @SerializedName("releases_url")
            val releasesUrl: String?,
            @SerializedName("size")
            val size: Int?,
            @SerializedName("ssh_url")
            val sshUrl: String?,
            @SerializedName("stargazers_count")
            val stargazersCount: Int?,
            @SerializedName("stargazers_url")
            val stargazersUrl: String?,
            @SerializedName("statuses_url")
            val statusesUrl: String?,
            @SerializedName("subscribers_url")
            val subscribersUrl: String?,
            @SerializedName("subscription_url")
            val subscriptionUrl: String?,
            @SerializedName("svn_url")
            val svnUrl: String?,
            @SerializedName("tags_url")
            val tagsUrl: String?,
            @SerializedName("teams_url")
            val teamsUrl: String?,
            @SerializedName("temp_clone_token")
            val tempCloneToken: String?,
            @SerializedName("topics")
            val topics: List<String?>?,
            @SerializedName("trees_url")
            val treesUrl: String?,
            @SerializedName("updated_at")
            val updatedAt: String?,
            @SerializedName("url")
            val url: String?,
            @SerializedName("watchers")
            val watchers: Int?,
            @SerializedName("watchers_count")
            val watchersCount: Int?
        ) {
             class License(
                @SerializedName("key")
                val key: String?,
                @SerializedName("name")
                val name: String?,
                @SerializedName("node_id")
                val nodeId: String?,
                @SerializedName("spdx_id")
                val spdxId: String?,
                @SerializedName("url")
                val url: String?
            )

             class Owner(
                @SerializedName("avatar_url")
                val avatarUrl: String?,
                @SerializedName("events_url")
                val eventsUrl: String?,
                @SerializedName("followers_url")
                val followersUrl: String?,
                @SerializedName("following_url")
                val followingUrl: String?,
                @SerializedName("gists_url")
                val gistsUrl: String?,
                @SerializedName("gravatar_id")
                val gravatarId: String?,
                @SerializedName("html_url")
                val htmlUrl: String?,
                @SerializedName("id")
                val id: Int?,
                @SerializedName("login")
                val login: String?,
                @SerializedName("node_id")
                val nodeId: String?,
                @SerializedName("organizations_url")
                val organizationsUrl: String?,
                @SerializedName("received_events_url")
                val receivedEventsUrl: String?,
                @SerializedName("repos_url")
                val reposUrl: String?,
                @SerializedName("site_admin")
                val siteAdmin: Boolean?,
                @SerializedName("starred_url")
                val starredUrl: String?,
                @SerializedName("subscriptions_url")
                val subscriptionsUrl: String?,
                @SerializedName("type")
                val type: String?,
                @SerializedName("url")
                val url: String?
            )

             class Permissions(
                @SerializedName("admin")
                val admin: Boolean?,
                @SerializedName("pull")
                val pull: Boolean?,
                @SerializedName("push")
                val push: Boolean?
            )
        }

         class User(
            @SerializedName("avatar_url")
            val avatarUrl: String?,
            @SerializedName("events_url")
            val eventsUrl: String?,
            @SerializedName("followers_url")
            val followersUrl: String?,
            @SerializedName("following_url")
            val followingUrl: String?,
            @SerializedName("gists_url")
            val gistsUrl: String?,
            @SerializedName("gravatar_id")
            val gravatarId: String?,
            @SerializedName("html_url")
            val htmlUrl: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("login")
            val login: String?,
            @SerializedName("node_id")
            val nodeId: String?,
            @SerializedName("organizations_url")
            val organizationsUrl: String?,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String?,
            @SerializedName("repos_url")
            val reposUrl: String?,
            @SerializedName("site_admin")
            val siteAdmin: Boolean?,
            @SerializedName("starred_url")
            val starredUrl: String?,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String?,
            @SerializedName("type")
            val type: String?,
            @SerializedName("url")
            val url: String?
        )
    }

     class Label(
        @SerializedName("color")
        val color: String?,
        @SerializedName("default")
        val default: Boolean?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("node_id")
        val nodeId: String?,
        @SerializedName("url")
        val url: String?
    )

     class Links(
        @SerializedName("comments")
        val comments: Comments?,
        @SerializedName("commits")
        val commits: Commits?,
        @SerializedName("html")
        val html: Html?,
        @SerializedName("issue")
        val issue: Issue?,
        @SerializedName("review_comment")
        val reviewComment: ReviewComment?,
        @SerializedName("review_comments")
        val reviewComments: ReviewComments?,
        @SerializedName("self")
        val self: Self?,
        @SerializedName("statuses")
        val statuses: Statuses?
    ) {
         class Comments(
            @SerializedName("href")
            val href: String?
        )

         class Commits(
            @SerializedName("href")
            val href: String?
        )

         class Html(
            @SerializedName("href")
            val href: String?
        )

         class Issue(
            @SerializedName("href")
            val href: String?
        )

         class ReviewComment(
            @SerializedName("href")
            val href: String?
        )

         class ReviewComments(
            @SerializedName("href")
            val href: String?
        )

         class Self(
            @SerializedName("href")
            val href: String?
        )

         class Statuses(
            @SerializedName("href")
            val href: String?
        )
    }

     class MergedBy(
        @SerializedName("avatar_url")
        val avatarUrl: String?,
        @SerializedName("events_url")
        val eventsUrl: String?,
        @SerializedName("followers_url")
        val followersUrl: String?,
        @SerializedName("following_url")
        val followingUrl: String?,
        @SerializedName("gists_url")
        val gistsUrl: String?,
        @SerializedName("gravatar_id")
        val gravatarId: String?,
        @SerializedName("html_url")
        val htmlUrl: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("login")
        val login: String?,
        @SerializedName("node_id")
        val nodeId: String?,
        @SerializedName("organizations_url")
        val organizationsUrl: String?,
        @SerializedName("received_events_url")
        val receivedEventsUrl: String?,
        @SerializedName("repos_url")
        val reposUrl: String?,
        @SerializedName("site_admin")
        val siteAdmin: Boolean?,
        @SerializedName("starred_url")
        val starredUrl: String?,
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String?,
        @SerializedName("type")
        val type: String?,
        @SerializedName("url")
        val url: String?
    )

     class Milestone(
        @SerializedName("closed_at")
        val closedAt: String?,
        @SerializedName("closed_issues")
        val closedIssues: Int?,
        @SerializedName("created_at")
        val createdAt: String?,
        @SerializedName("creator")
        val creator: Creator?,
        @SerializedName("description")
        val description: String?,
        @SerializedName("due_on")
        val dueOn: String?,
        @SerializedName("html_url")
        val htmlUrl: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("labels_url")
        val labelsUrl: String?,
        @SerializedName("node_id")
        val nodeId: String?,
        @SerializedName("number")
        val number: Int?,
        @SerializedName("open_issues")
        val openIssues: Int?,
        @SerializedName("state")
        val state: String?,
        @SerializedName("title")
        val title: String?,
        @SerializedName("updated_at")
        val updatedAt: String?,
        @SerializedName("url")
        val url: String?
    ) {
         class Creator(
            @SerializedName("avatar_url")
            val avatarUrl: String?,
            @SerializedName("events_url")
            val eventsUrl: String?,
            @SerializedName("followers_url")
            val followersUrl: String?,
            @SerializedName("following_url")
            val followingUrl: String?,
            @SerializedName("gists_url")
            val gistsUrl: String?,
            @SerializedName("gravatar_id")
            val gravatarId: String?,
            @SerializedName("html_url")
            val htmlUrl: String?,
            @SerializedName("id")
            val id: Int?,
            @SerializedName("login")
            val login: String?,
            @SerializedName("node_id")
            val nodeId: String?,
            @SerializedName("organizations_url")
            val organizationsUrl: String?,
            @SerializedName("received_events_url")
            val receivedEventsUrl: String?,
            @SerializedName("repos_url")
            val reposUrl: String?,
            @SerializedName("site_admin")
            val siteAdmin: Boolean?,
            @SerializedName("starred_url")
            val starredUrl: String?,
            @SerializedName("subscriptions_url")
            val subscriptionsUrl: String?,
            @SerializedName("type")
            val type: String?,
            @SerializedName("url")
            val url: String?
        )
    }

     class RequestedReviewer(
        @SerializedName("avatar_url")
        val avatarUrl: String?,
        @SerializedName("events_url")
        val eventsUrl: String?,
        @SerializedName("followers_url")
        val followersUrl: String?,
        @SerializedName("following_url")
        val followingUrl: String?,
        @SerializedName("gists_url")
        val gistsUrl: String?,
        @SerializedName("gravatar_id")
        val gravatarId: String?,
        @SerializedName("html_url")
        val htmlUrl: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("login")
        val login: String?,
        @SerializedName("node_id")
        val nodeId: String?,
        @SerializedName("organizations_url")
        val organizationsUrl: String?,
        @SerializedName("received_events_url")
        val receivedEventsUrl: String?,
        @SerializedName("repos_url")
        val reposUrl: String?,
        @SerializedName("site_admin")
        val siteAdmin: Boolean?,
        @SerializedName("starred_url")
        val starredUrl: String?,
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String?,
        @SerializedName("type")
        val type: String?,
        @SerializedName("url")
        val url: String?
    )

     class RequestedTeam(
        @SerializedName("description")
        val description: String?,
        @SerializedName("html_url")
        val htmlUrl: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("members_url")
        val membersUrl: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("node_id")
        val nodeId: String?,
        @SerializedName("permission")
        val permission: String?,
        @SerializedName("privacy")
        val privacy: String?,
        @SerializedName("repositories_url")
        val repositoriesUrl: String?,
        @SerializedName("slug")
        val slug: String?,
        @SerializedName("url")
        val url: String?
    )

     class User(
        @SerializedName("avatar_url")
        val avatarUrl: String?,
        @SerializedName("events_url")
        val eventsUrl: String?,
        @SerializedName("followers_url")
        val followersUrl: String?,
        @SerializedName("following_url")
        val followingUrl: String?,
        @SerializedName("gists_url")
        val gistsUrl: String?,
        @SerializedName("gravatar_id")
        val gravatarId: String?,
        @SerializedName("html_url")
        val htmlUrl: String?,
        @SerializedName("id")
        val id: Int?,
        @SerializedName("login")
        val login: String?,
        @SerializedName("node_id")
        val nodeId: String?,
        @SerializedName("organizations_url")
        val organizationsUrl: String?,
        @SerializedName("received_events_url")
        val receivedEventsUrl: String?,
        @SerializedName("repos_url")
        val reposUrl: String?,
        @SerializedName("site_admin")
        val siteAdmin: Boolean?,
        @SerializedName("starred_url")
        val starredUrl: String?,
        @SerializedName("subscriptions_url")
        val subscriptionsUrl: String?,
        @SerializedName("type")
        val type: String?,
        @SerializedName("url")
        val url: String?
    )
}