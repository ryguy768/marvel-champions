<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'game.label', default: 'Game')}"/>
    <title><g:message code="default.create.label" args="[entityName]"/></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'bootstrap.css')}" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>

<body>
<a href="#create-game" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="create-game" class="content scaffold-create" role="main">
    <h1><g:message code="default.create.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">

        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${this.game}">
        <ul class="errors" role="alert">
            <g:eachError bean="${this.game}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form resource="${this.game}" method="POST">
        <fieldset class="form">

            <div class="fieldcontain required">
                <label for="scenario">Scenario<span class="required-indicator">*</span></label>
                <g:select name="scenario.id" from="${scenarios}" optionKey="id" optionValue="scenarioName" required=""
                          id="scenario"/>
            </div>

            <div class="fieldcontain required">
                <label for="hero">Heroes</label>
                <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#heroModal">
                    Add Hero
                </button>
            </div>


            <div class="fieldcontain required">
                <label>Selected Heroes</label>

                <div id="selectedHeroes" class="mt-2"></div>

                <div id="heroInputs"></div>
            </div>

            <div class="fieldcontain required">
                <label for="difficultyLevel">Difficulty Level<span class="required-indicator">*</span></label>
                <select name="difficultyLevel" id="difficultyLevel">
                    <option value="Standard">Standard</option>
                    <option value="Expert">Expert</option>
                </select>
            </div>

            <div class="fieldcontain required">
                <label for="modularSet">Modular Set<span class="required-indicator">*</span></label>
                <g:select name="modularSet.id" from="${modularSets}" optionKey="id" optionValue="encounterName"
                          required=""
                          id="modularSet"/>
            </div>

            <div class="fieldcontain required">
                <label for="outcome">Outcome<span class="required-indicator">*</span></label>
                <select name="outcome" id="outcome">
                    <option value="Win">Win</option>
                    <option value="Lose">Lose</option>
                </select>
            </div>

            <div class="fieldcontain required">
                <label for="funRating">Fun Rating<span class="required-indicator">*</span></label>
                <input type="number" name="funRating" min="0" max="5" required="" id="funRating"/>
            </div>

            <div class="fieldcontain required">
                <label for="difficultyRating">Difficulty Rating<span class="required-indicator">*</span></label>
                <input type="number" name="difficultyRating" min="0" max="5" required="" id="difficultyRating"/>
            </div>

            <div class="modal fade" id="heroModal" tabindex="-1" role="dialog" aria-labelledby="heroModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="heroModalLabel">Add Hero</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body">
                            <div class="form-group">
                                <label for="hero">Hero</label>
                                <g:select name="hero.id" from="${heroes}" optionKey="id" optionValue="heroName"
                                          required="" id="hero" class="form-control"/>
                            </div>

                            <div class="form-group">
                                <label for="aspect">Aspect</label>
                                <select name="aspect" id="aspect" class="form-control">
                                    <option value="Aggression">Aggression</option>
                                    <option value="Justice">Justice</option>
                                    <option value="Leadership">Leadership</option>
                                    <option value="Protection">Protection</option>
                                </select>
                            </div>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary" id="addHeroBtn">Save Hero</button>
                        </div>
                    </div>
                </div>
            </div>
        </fieldset>
        <fieldset class="buttons">
            <g:submitButton name="create" class="save"
                            value="${message(code: 'default.button.create.label', default: 'Create')}"/>
        </fieldset>
    </g:form>
</div>
<script>
    $(document).ready(function () {
        let heroCount = 0;

        console.log("Document ready");

        $("#addHeroBtn").click(function () {
            console.log("Add hero button clicked");

            const heroId = $("#hero").val();
            const heroName = $("#hero option:selected").text();
            const aspect = $("#aspect").val();

            console.log("Selected hero:", heroName, "with aspect:", aspect);

            if (!heroId || !heroName || !aspect) {
                alert("Please select a hero and aspect");
                return;
            }

            const heroElement =
                '<div class="hero-item mb-2 p-2 border rounded" style="display:flex; justify-content:space-between;">' +
                '<div><strong>' + heroName + '</strong> - ' + aspect + '</div>' +
                '<button type="button" class="btn btn-sm btn-danger remove-hero" ' +
                'data-hero-id="' + heroCount + '">Remove</button>' +
                '</div>';

            const heroInputs =
                '<input type="hidden" name="heroes[' + heroCount + '].id" value="' + heroId + '">' +
                '<input type="hidden" name="heroes[' + heroCount + '].aspect" value="' + aspect + '">';

            $("#selectedHeroes").append(heroElement);
            $("#heroInputs").append(heroInputs);

            console.log("Added hero element:", $("#selectedHeroes").html());

            heroCount++;
            $("#heroModal").modal('hide');
        });

        $(document).on("click", ".remove-hero", function () {
            const heroId = $(this).data("hero-id");
            $(this).closest(".hero-item").remove();
            $(`input[name="heroes[${heroId}].id"]`).remove();
            $(`input[name="heroes[${heroId}].aspect"]`).remove();
        });
    });
</script>
</body>
</html>